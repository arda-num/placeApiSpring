package com.example.placeapi.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private String jwt;
    private String userName;
    private String password;
    private String name;
    private String familyName;
    private Integer age;

}
