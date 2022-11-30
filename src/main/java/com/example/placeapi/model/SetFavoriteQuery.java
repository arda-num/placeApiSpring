package com.example.placeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SetFavoriteQuery {
    private String username;
    private String placeid;
}
