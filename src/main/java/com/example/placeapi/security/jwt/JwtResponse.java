package com.example.placeapi.security.jwt;

import com.example.placeapi.model.FavoritePlace;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {

    private String jwt;
    private String username;
    private String name;
    private String familyName;
    private Integer age;
    private List<String> roles;
    private List<FavoritePlace> favoritePlaces;
}
