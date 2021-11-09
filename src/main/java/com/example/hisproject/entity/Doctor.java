package com.example.hisproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("doctor")
public class Doctor {
    private Long id;
    private String name;
    private String department;
    private String details;
}
