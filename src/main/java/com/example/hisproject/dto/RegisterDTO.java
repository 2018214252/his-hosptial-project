package com.example.hisproject.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO {
    private String name;
    private String number;
    private String phoneNumber;
    private String password;
    private String repeat;
}
