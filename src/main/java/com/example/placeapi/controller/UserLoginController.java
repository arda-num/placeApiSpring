package com.example.placeapi.controller;


import com.example.placeapi.model.User;
import com.example.placeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/login")
public class UserLoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Boolean loginUser(@RequestParam("username") String userName, @RequestParam("password") String password) {
        Optional<User> user = userRepository.findUserByUserName(userName);
        return user.filter(value -> Objects.equals(value.getUserPassword(), password)).isPresent();
    }

}
