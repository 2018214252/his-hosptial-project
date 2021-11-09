package com.example.hisproject.controller;

import com.example.hisproject.common.Role;
import com.example.hisproject.dto.RegisterDTO;
import com.example.hisproject.entity.Department;
import com.example.hisproject.entity.Patient;
import com.example.hisproject.entity.Regd;
import com.example.hisproject.entity.User;
import com.example.hisproject.service.*;
import com.example.hisproject.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "处理用户通用操作请求", tags = {"Authorization"})
@RestController
@RequestMapping("/api/common/")
@Slf4j
public class CommonController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private RegdService regdService;
    @Autowired
    private MedicalRecordsService medicalRecordsService;
    @Autowired
    private PrescriptionService prescriptionService;


    @ApiOperation("加载所有科室信息")
    @GetMapping("departments")
    public ResultVO getAllDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        return ResultVO.success(Map.of("departments",departments));
    }

    @ApiOperation("查看医生")
    @GetMapping("doctors/{dname}")
    public ResultVO getAllDots(@PathVariable String dname){
        return ResultVO.success(Map.of("doctors",doctorService.getDotByD(dname)));
    }

    @ApiOperation("预约")
    @PostMapping("regd")
    public ResultVO insertRegd(@RequestAttribute("uid") Long id,@RequestBody Regd regd){
        log.debug("ad");
        regd.setPatient(id);
        regdService.insertRegd(regd);
        return ResultVO.success(Map.of("regds",regdService.getRByP(id)));
    }

    @ApiOperation("取消预约")
    @DeleteMapping("regd/{rid}")
    public ResultVO deleteRegd(@RequestAttribute("uid") Long id,@PathVariable Long rid){
        regdService.deleteRegd(rid);
        return ResultVO.success(Map.of("regds",regdService.getRByP(id)));
    }

    @ApiOperation("查看个人预约记录")
    @GetMapping("regds")
    public ResultVO getRByP(@RequestAttribute("uid") Long id){
        return ResultVO.success(Map.of("regds",regdService.getRByP(id)));
    }

    @ApiOperation("查看医嘱")
    @GetMapping("medicalRecord/{id}")
    public ResultVO getMRBy(@PathVariable("id") Long id){
        return ResultVO.success(Map.of("medicalRecord",medicalRecordsService.selectMRById(id)));
    }

    @ApiOperation("查看药方")
    @GetMapping("prescription/{id}")
    public ResultVO getPrescription(@PathVariable Long id){
        return ResultVO.success(Map.of("prescription",prescriptionService.getPrescription(id)));
    }
}
