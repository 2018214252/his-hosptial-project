package com.example.hisproject.service;

import com.example.hisproject.entity.Medicine;
import com.example.hisproject.mapper.MedicineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class MedicineService {
    @Autowired
    private MedicineMapper medicineMapper;

    public void insertMedicine(Medicine medicine){
        medicineMapper.insert(medicine);
    }

    public void deleteMedicine(Long id){
        medicineMapper.deleteById(id);
    }

    public void updateMedicine(Medicine medicine){
        medicineMapper.update(medicine);
    }

    public List<Medicine> getAllMedicine(){
        return medicineMapper.list();
    }
}
