package com.example.hisproject.controller;

import com.example.hisproject.entity.MedicalRecords;
import com.example.hisproject.entity.Prescription;
import com.example.hisproject.entity.Regd;
import com.example.hisproject.service.MedicalRecordsService;
import com.example.hisproject.service.MedicineService;
import com.example.hisproject.service.PrescriptionService;
import com.example.hisproject.service.RegdService;
import com.example.hisproject.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "处理医生操作请求", tags = {"Authorization, Doctor"})
@RestController
@RequestMapping("/api/doctor/")
@Slf4j
public class DoctorController {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private RegdService regdService;
    @Autowired
    private MedicalRecordsService medicalRecordsService;
    @Autowired
    private PrescriptionService prescriptionService;

    @ApiOperation("查看所有药品")
    @GetMapping("medicines")
    public ResultVO getAllMedicine(){
        return ResultVO.success(Map.of("medicine",medicineService.getAllMedicine()));
    }

    @ApiOperation("查看个人预约记录")
    @GetMapping("regds")
    public ResultVO getRByD(@RequestAttribute("uid") Long id){
        return ResultVO.success(Map.of("regds",regdService.getRByD(id)));
    }

    @ApiOperation("查看预约记录")
    @GetMapping("regd/{id}")
    public ResultVO getRByID(@PathVariable Long id){
        return ResultVO.success(Map.of("regd",regdService.getRById(id)));
    }

    @ApiOperation("更新预约记录")
    @PatchMapping("regd")
    public ResultVO updateRedg(@RequestBody Regd regd){
        regdService.updateRegd(regd);
        return ResultVO.success(Map.of());
    }

    @ApiOperation("就诊")
    @PostMapping("medicalRecord")
    public ResultVO insertMR(@RequestBody MedicalRecords medicalRecords){
        log.debug(medicalRecords.getDetails());
        medicalRecordsService.insertMR(medicalRecords);
        return ResultVO.success(Map.of());
    }

    @ApiOperation("开药")
    @PostMapping("prescription")
    public ResultVO insertPrescription(@RequestBody Prescription prescription){
        prescriptionService.insertPrescription(prescription);
        return ResultVO.success(Map.of());
    }

    @ApiOperation("查看指定开药记录")
    @GetMapping("prescription/{id}")
    public ResultVO getPrescriptionById(@PathVariable Long id){
        return ResultVO.success(Map.of("prescription",prescriptionService.getPrescriptionById(id)));
    }
}
