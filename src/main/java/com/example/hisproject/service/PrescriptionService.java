package com.example.hisproject.service;

import com.example.hisproject.dto.PrescriptionDTO;
import com.example.hisproject.entity.Medicine;
import com.example.hisproject.entity.Prescription;
import com.example.hisproject.mapper.MedicineMapper;
import com.example.hisproject.mapper.PrescriptionMapper;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PrescriptionService {
    @Autowired
    private PrescriptionMapper prescriptionMapper;
    @Autowired
    private MedicineMapper medicineMapper;

    public void insertPrescription(Prescription prescription){
        prescriptionMapper.insert(prescription);
    }

    public List<Prescription> getPrescription(Long id){
        return prescriptionMapper.getPrescription(id);
    }

    public List<PrescriptionDTO> getPrescriptionById(Long id){
        List<Prescription> prescriptions = prescriptionMapper.getPrescription(id);
        List<PrescriptionDTO> prescriptionDTOS = new ArrayList<>();
        prescriptions.forEach(p->{
            Medicine medicine = medicineMapper.selectById(p.getMedicine());
            PrescriptionDTO prescriptionDTO = PrescriptionDTO.builder()
                    .pid(p.getPid())
                    .mid(medicine.getId())
                    .medicineName(medicine.getName())
                    .medicinePrice(medicine.getPrice())
                    .medicineDetails(medicine.getDetails())
                    .medicineInventory(medicine.getInventory())
                    .build();
            prescriptionDTOS.add(prescriptionDTO);
        });
        return prescriptionDTOS;
    }
}
