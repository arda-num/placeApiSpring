package com.example.placeapi.model;


import lombok.Data;

import java.util.List;

@Data
public class PlaceResponse {

    private List<Place> results;

}
