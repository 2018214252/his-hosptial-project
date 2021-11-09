package com.example.hisproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("prescription")
public class Prescription {
    private Long id;
    private Long pid;//
    private Long medicine;
    private String createTime;
}
