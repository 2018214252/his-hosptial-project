package com.example.hisproject.service;

import com.example.hisproject.entity.Patient;
import com.example.hisproject.mapper.PatientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    public void insertPatient(Patient patient){
        patientMapper.insert(patient);
    }
}
