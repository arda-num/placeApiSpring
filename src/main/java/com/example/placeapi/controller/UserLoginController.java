package com.example.placeapi.controller;


import com.example.placeapi.model.User;
import com.example.placeapi.repository.UserRepository;
import com.example.placeapi.security.jwt.JwtResponse;
import com.example.placeapi.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/login")
public class UserLoginController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> loginUser(@RequestParam("username") String userName, @RequestParam("password") String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        Optional<User> user = userRepository.findUserByUserName(userName);

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                user.get().getUserName(),
                user.get().getUserPassword(),
                user.get().getName(),
                user.get().getFamilyName(),
                user.get().getAge()
        ));
    }

}
