package com.example.placeapi.controller;

import com.example.placeapi.model.Place;
import com.example.placeapi.model.SearchPlaceQuery;
import com.example.placeapi.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/search")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public List<Place> searchPlace(@RequestBody SearchPlaceQuery searchPlaceQuery){
        return placeService.searchPlace(searchPlaceQuery.getLatitude(), searchPlaceQuery.getLongitude());
    }

}
