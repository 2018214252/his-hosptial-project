package com.example.hisproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("patient")
public class Patient {
    private Long id;
    private String name;
    private String number;
}
