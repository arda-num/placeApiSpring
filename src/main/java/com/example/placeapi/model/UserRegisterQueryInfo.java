package com.example.placeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterQueryInfo {
    private String userName;
    private String userPassword;
    private String name;
    private String familyName;
    private Integer age;
    private List<String> roles;
    private LocalDateTime registrationTime;

}
