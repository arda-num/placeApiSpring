package com.example.placeapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {
    @Indexed(unique = true)
    private String username;
    private String userPassword;
    private String name;
    private String familyName;
    private Integer age;
    private LocalDateTime registrationTime = LocalDateTime.now();

    private List<String> roles;

    public Customer(String username, String userPassword, String name, String familyName, Integer age, List<String> roles) {
        this.username = username;
        this.userPassword = userPassword;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.roles = roles;
    }


}
