package com.example.hisproject.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegdDTO {
    private Long id;
    private String department;
    private String doctor;
    private String patientName;
    private String patientNumber;
    private String flag;//是否就诊
    private String createTime;
    private String medicalTime;
}
