package com.example.hisproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("medical_records")
public class MedicalRecords {//就诊记录
    private Long id;
    private String details;//医嘱
    private String createTime;
}
