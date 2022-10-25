package com.example.placeapi.service;

import com.example.placeapi.model.Place;
import com.example.placeapi.model.PlaceResponse;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@Service
@CommonsLog
public class PlaceService {

    private final static String BASE_URL = "https://api.foursquare.com/v3";
    private final static String SEARCH_URL = BASE_URL + "/places/search";

    @Autowired
    @Qualifier("placeApiRestTemplate")
    private RestTemplate restTemplate;

    // caching for 5 min -> caffeine -> redis
    // favori işaretleme endpointi
    // favorileri listeleyen endpoint getALl()
    // favori database'i
    // Angular önyüz
    // springdata mongodb

    public List<Place> searchPlace(float latitude, float longitude) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(SEARCH_URL)
                .queryParam("ll", latitude + "," + longitude); // uri

        PlaceResponse response = restTemplate.getForObject(builder.build().toUri(), PlaceResponse.class);

        List<Place> results = response.getResults();
        results.forEach(place -> log.info("place: " + place));
        return results;

    }

}
