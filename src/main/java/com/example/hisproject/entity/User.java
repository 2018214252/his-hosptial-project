package com.example.hisproject.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String userName;
    private String password;
    private int role;
}
