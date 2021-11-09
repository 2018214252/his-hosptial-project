package com.example.hisproject.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Regd {
    private Long id;
    private String department;
    private Long doctor;
    private Long patient;
    private String flag;//是否就诊
    private String createTime;
}
