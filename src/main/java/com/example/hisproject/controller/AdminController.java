package com.example.hisproject.controller;

import com.example.hisproject.common.Role;
import com.example.hisproject.entity.Department;
import com.example.hisproject.entity.Doctor;
import com.example.hisproject.entity.Medicine;
import com.example.hisproject.entity.User;
import com.example.hisproject.service.DepartmentService;
import com.example.hisproject.service.DoctorService;
import com.example.hisproject.service.MedicineService;
import com.example.hisproject.service.UserService;
import com.example.hisproject.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "处理管理员通用操作请求", tags = {"Authorization,Admin"})
@RestController
@RequestMapping("/api/admin/")
@Slf4j
public class AdminController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

    @ApiOperation("添加科室")
    @PostMapping("department")
    public ResultVO insertDepartment(@RequestBody Department department){
        departmentService.insertDepartment(department);
        return ResultVO.success(Map.of("departments",departmentService.getAllDepartments()));
    }

    @ApiOperation("删除科室")
    @DeleteMapping("department/{id}")
    public ResultVO deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResultVO.success(Map.of("departments",departmentService.getAllDepartments()));
    }

    @ApiOperation("添加药品")
    @PostMapping("medicine")
    public ResultVO insertMedicine(@RequestBody Medicine medicine){
        medicineService.insertMedicine(medicine);
        return ResultVO.success(Map.of("medicine",medicineService.getAllMedicine()));
    }

    @ApiOperation("删除药品")
    @DeleteMapping("medicine/{id}")
    public ResultVO deleteMedicine(@PathVariable Long id){
        medicineService.deleteMedicine(id);
        return ResultVO.success(Map.of("medicine",medicineService.getAllMedicine()));
    }

    @ApiOperation("更改药品")
    @PatchMapping("medicine")
    public ResultVO updateMedicine(@RequestBody Medicine medicine){
        medicineService.updateMedicine(medicine);
        return ResultVO.success(Map.of("medicine",medicineService.getAllMedicine()));
    }

    @ApiOperation("查看所有药品")
    @GetMapping("medicines")
    public ResultVO getAllMedicine(){
        return ResultVO.success(Map.of("medicine",medicineService.getAllMedicine()));
    }

    @ApiOperation("添加医生")
    @PostMapping("doctor")
    public ResultVO insertDot(@RequestBody Doctor doctor){
       User user = User.builder()
               .userName(doctor.getId().toString())
               .password(doctor.getId().toString())
               .id(doctor.getId())
               .role(Role.DOCTOR)
               .build();
       if(userService.getUserByName(doctor.getId().toString())!=null){
           userService.insertUser(user);
       }
       userService.insertUser(user);
       doctorService.insertDot(doctor);
       return ResultVO.success(Map.of("doctors",doctorService.getAllDots()));
    }

    @ApiOperation("删除医生")
    @DeleteMapping("doctor/{id}")
    public ResultVO deleteDot(@PathVariable Long id){
        doctorService.deleteDot(id);
        userService.deleteUser(id);
        return ResultVO.success(Map.of("doctors",doctorService.getAllDots()));
    }

    @ApiOperation("修改医生信息")
    @PatchMapping("doctor")
    public ResultVO updateDot(@RequestBody Doctor doctor){
        //log.debug(doctor.getId().toString());
        //log.debug(doctor.getName());
        doctorService.updateDot(doctor);
        return ResultVO.success(Map.of("doctors",doctorService.getAllDots()));
    }

    @ApiOperation("查看所有医生")
    @GetMapping("doctors")
    public ResultVO getAllDots(){
        return ResultVO.success(Map.of("doctors",doctorService.getAllDots()));
    }

    @ApiOperation("删除账号")
    @DeleteMapping("user/{id}")
    public ResultVO deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResultVO.success(Map.of("users",userService.getAllUsers()));
    }

    @ApiOperation("获取所有账号")
    @GetMapping("users")
    public ResultVO getAllUsers(){
        return ResultVO.success(Map.of("users",userService.getAllUsers()));
    }

    @ApiOperation("创建账号")
    @PostMapping("user")
    public ResultVO insertUser(@RequestBody User user){
        userService.insertUser(user);
        return ResultVO.success(Map.of());
    }
}
