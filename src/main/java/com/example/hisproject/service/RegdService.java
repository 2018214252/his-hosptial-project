package com.example.hisproject.service;

import com.example.hisproject.dto.RegdDTO;
import com.example.hisproject.entity.Doctor;
import com.example.hisproject.entity.MedicalRecords;
import com.example.hisproject.entity.Patient;
import com.example.hisproject.entity.Regd;
import com.example.hisproject.mapper.DoctorMapper;
import com.example.hisproject.mapper.MedicalRecordsMapper;
import com.example.hisproject.mapper.PatientMapper;
import com.example.hisproject.mapper.RegdMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class RegdService {
    @Autowired
    private RegdMapper regdMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private MedicalRecordsMapper medicalRecordsMapper;

    public void insertRegd(Regd regd) {
        regdMapper.insert(regd);
    }

    public void deleteRegd(Long id) {
        regdMapper.deleteById(id);
    }

    public void updateRegd(Regd regd){
        regdMapper.update(regd);
    }

    public List<RegdDTO> getRByP(Long id) {
        List<RegdDTO> regdDTOS = new ArrayList<>();
        List<Regd> regds = regdMapper.getRByP(id);
        regds.forEach(regd -> {
            Doctor doctor = doctorMapper.selectById(regd.getDoctor());
            Patient patient = patientMapper.selectById(regd.getPatient());
            log.debug(doctor.getName());
            RegdDTO regdDTO = RegdDTO.builder()
                    .id(regd.getId())
                    .department(regd.getDepartment())
                    .patientName(patient.getName())
                    .patientNumber(patient.getNumber())
                    .createTime(regd.getCreateTime())
                    .flag(regd.getFlag())
                    .doctor(doctor.getName())
                    .build();
            if(regd.getFlag().equals("是")){
                MedicalRecords medicalRecords = medicalRecordsMapper.selectById(regd.getId());
                regdDTO.setMedicalTime(medicalRecords.getCreateTime());
            }
            regdDTOS.add(regdDTO);
        });
        return regdDTOS;
    }

    public List<RegdDTO> getRByD(Long id) {
        List<RegdDTO> regdDTOS = new ArrayList<>();
        List<Regd> regds = regdMapper.getRByD(id);
        regds.forEach(regd -> {
            Doctor doctor = doctorMapper.selectById(regd.getDoctor());
            Patient patient = patientMapper.selectById(regd.getPatient());
            RegdDTO regdDTO = RegdDTO.builder()
                    .id(regd.getId())
                    .department(regd.getDepartment())
                    .patientName(patient.getName())
                    .patientNumber(patient.getNumber())
                    .createTime(regd.getCreateTime())
                    .flag(regd.getFlag())
                    .doctor(doctor.getName())
                    .build();
            if(regd.getFlag().equals("是")){
                MedicalRecords medicalRecords = medicalRecordsMapper.selectById(regd.getId());
                regdDTO.setMedicalTime(medicalRecords.getCreateTime());
            }
            regdDTOS.add(regdDTO);
        });
        return regdDTOS;
    }

    public RegdDTO getRById(Long id) {

        Regd regd = regdMapper.getRById(id);
        Doctor doctor = doctorMapper.selectById(regd.getDoctor());
        Patient patient = patientMapper.selectById(regd.getPatient());
        RegdDTO regdDTO = RegdDTO.builder()
                .id(regd.getId())
                .department(regd.getDepartment())
                .patientName(patient.getName())
                .patientNumber(patient.getNumber())
                .createTime(regd.getCreateTime())
                .flag(regd.getFlag())
                .doctor(doctor.getName())
                .build();
        return regdDTO;
    }
}
