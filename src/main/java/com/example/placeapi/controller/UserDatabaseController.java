package com.example.placeapi.controller;


import com.example.placeapi.model.Customer;
import com.example.placeapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserDatabaseController {

    @Autowired
    private CustomerRepository userRepository;


    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam("userName") String username) {
        userRepository.deleteById(username);
    }

    @GetMapping("/info")
    public Customer getUser(@RequestParam("username") String username) {
        return userRepository.findCustomerByUsername(username).get();
    }

}

