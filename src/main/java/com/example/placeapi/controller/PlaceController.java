package com.example.placeapi.controller;

import com.example.placeapi.model.Place;
import com.example.placeapi.model.SearchPlaceQuery;
import com.example.placeapi.service.PlaceService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CommonsLog
@RequestMapping(path = "/api/v1/search")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public List<Place> searchPlace(@RequestBody SearchPlaceQuery searchPlaceQuery) {

        StopWatch stopWatch = new StopWatch("arda"); // AOP ile logla. how to define annotations manually?
        stopWatch.start();
        List<Place> places = placeService.searchPlace(searchPlaceQuery.getLatitude(), searchPlaceQuery.getLongitude());

        stopWatch.stop();
        log.info("Execution Time: " + stopWatch);

        return places;
    }
}
