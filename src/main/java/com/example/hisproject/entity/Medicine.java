package com.example.hisproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("medicine")
public class Medicine {
    private Long id;
    private String name;
    private int inventory;
    private int price;
    private String details;
}
