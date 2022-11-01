package com.example.placeapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    @Indexed(unique = true)
    private String userName;
    private String userPassword;
    private String name;
    private String familyName;
    private Integer age;
    private LocalDateTime registrationTime = LocalDateTime.now();

    public User(String userName, String userPassword, String name, String familyName, Integer age) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
    }
}
