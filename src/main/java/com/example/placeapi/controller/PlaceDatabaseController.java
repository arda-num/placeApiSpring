package com.example.placeapi.controller;


import com.example.placeapi.model.Place;
import com.example.placeapi.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/db")
public class PlaceDatabaseController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping(path = "/places")
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping(path = "/place")
    public Optional<Place> getPlace(@RequestParam("id") String id) {
        return placeRepository.findById(id);
    }

}
