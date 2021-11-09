package com.example.hisproject.service;

import com.example.hisproject.entity.MedicalRecords;
import com.example.hisproject.mapper.MedicalRecordsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@Slf4j
public class MedicalRecordsService {
    @Autowired
    private MedicalRecordsMapper medicalRecordsMapper;

    public void insertMR(MedicalRecords medicalRecords){
        //log.debug(medicalRecords.getId().toString());
        //log.debug(medicalRecords.getDetails());
        medicalRecordsMapper.insert(medicalRecords);
    }
    public MedicalRecords selectMRById(Long id){
        return medicalRecordsMapper.selectById(id);
    }
}
