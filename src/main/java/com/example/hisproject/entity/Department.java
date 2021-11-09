package com.example.hisproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("department")
public class Department {
    private Long id;
    private String name;
}
