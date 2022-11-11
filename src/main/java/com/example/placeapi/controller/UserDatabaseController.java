package com.example.placeapi.controller;


import com.example.placeapi.model.User;
import com.example.placeapi.model.UserRegisterQueryInfo;
import com.example.placeapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserDatabaseController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterQueryInfo userRegisterQueryInfo) {

        if (userRepository.existsByUserName(userRegisterQueryInfo.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        User newUser = new User(
                userRegisterQueryInfo.getUserName(),
                userRegisterQueryInfo.getUserPassword(),
                userRegisterQueryInfo.getName(),
                userRegisterQueryInfo.getFamilyName(),
                userRegisterQueryInfo.getAge()
        );

        userRepository.insert(newUser);
        return ResponseEntity.ok("User registered successfully!");
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam("userid") String userId) {
        userRepository.deleteById(userId);
    }
}
