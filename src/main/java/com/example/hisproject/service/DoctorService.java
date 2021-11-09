package com.example.hisproject.service;

import com.example.hisproject.entity.Doctor;
import com.example.hisproject.mapper.DoctorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public void insertDot(Doctor doctor){
        doctorMapper.insert(doctor);
    }

    public void deleteDot(Long id){
        doctorMapper.deleteById(id);
    }

    public void updateDot(Doctor doctor){
        doctorMapper.updateDot(doctor);
    }

    public List<Doctor> getAllDots(){
        return doctorMapper.list();
    }

    public List<Doctor> getDotByD(String dname){
        return doctorMapper.getDotByD(dname);
    }
}
