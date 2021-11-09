package com.example.hisproject.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionDTO {
    private Long id;
    private Long pid;
    private Long mid;
    private String medicineName;
    private int medicinePrice;
    private int medicineInventory;
    private String medicineDetails;
}
