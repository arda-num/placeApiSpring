package com.example.placeapi.controller;


import com.example.placeapi.model.*;
import com.example.placeapi.repository.CustomerRepository;
import com.example.placeapi.repository.FavoritedByRepository;
import com.example.placeapi.security.jwt.JwtResponse;
import com.example.placeapi.security.jwt.JwtUtils;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
@CommonsLog
public class UserAuthenticationController {


    @Autowired
    FavoritedByRepository favoritedByRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private CustomerRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequestQuery loginRequestQuery) {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestQuery.getUsername(), loginRequestQuery.getPassword())
        );
        //CustomUserDetail user = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        CustomUserDetail user = (CustomUserDetail) authentication.getPrincipal();
        List<String> roles = user.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        //Optional<Customer> user = userRepository.findUserByUserName(userName);

        List<FavoritePlace> favoritePlaces = favoritedByRepository.findFavoritePlaceByUserName(user.getUsername());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                user.getUsername(),
                user.getName(),
                user.getFamilyName(),
                user.getAge(),
                roles,
                favoritePlaces

        ));
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterQueryInfo userRegisterQueryInfo) {

        if (userRepository.existsByUsername(userRegisterQueryInfo.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        log.info(userRegisterQueryInfo.getUserName());
        Customer newCustomer = new Customer(
                userRegisterQueryInfo.getUserName(),
                encoder.encode(userRegisterQueryInfo.getUserPassword()),
                userRegisterQueryInfo.getName(),
                userRegisterQueryInfo.getFamilyName(),
                userRegisterQueryInfo.getAge(),
                userRegisterQueryInfo.getRoles()
        );

        userRepository.insert(newCustomer);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}

