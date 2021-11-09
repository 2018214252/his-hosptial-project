package com.example.hisproject.controller;

import com.example.hisproject.common.EncryptComponent;
import com.example.hisproject.common.Role;
import com.example.hisproject.dto.RegisterDTO;
import com.example.hisproject.entity.Patient;
import com.example.hisproject.entity.User;
import com.example.hisproject.service.PatientService;
import com.example.hisproject.service.UserService;
import com.example.hisproject.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(value = "处理登录/未登录操作请求")
@RestController
@RequestMapping("/api/")
@Slf4j
public class LoginController {
    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @ApiOperation(value = "登录")
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response) {
        User u = userService.getUserByName(user.getUserName());
        log.debug(user.getUserName());
        log.debug(user.getPassword());
        if (u == null || !encoder.matches(user.getPassword(), u.getPassword())) {
            return ResultVO.error(401, "用户名密码错误");
        }
        String token = encryptComponent.encrypt(Map.of("uid", u.getId(), "role", u.getRole()));
        log.debug(token);
        response.addHeader("token", token);
        return ResultVO.success(Map.of("uid", u.getId(), "role", u.getRole()));
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public ResultVO registered(@RequestBody RegisterDTO registerDTO){
        User user = User.builder()
                .userName(registerDTO.getPhoneNumber())
                .password(registerDTO.getPassword())
                .build();
        if(userService.getUserByName(user.getUserName())!=null){
            return ResultVO.error(400,"用户名已注册");
        }
        user.setRole(Role.PATIENT);
        userService.insertUser(user);
        User u = userService.getUserByName(user.getUserName());
        Patient patient = Patient.builder()
                .id(u.getId())
                .name(registerDTO.getName())
                .number(registerDTO.getNumber())
                .build();
        patientService.insertPatient(patient);
        return ResultVO.success(Map.of());
    }
}

