package com.example.placeapi.service;

import com.example.placeapi.model.Place;
import com.example.placeapi.model.PlaceResponse;
import com.example.placeapi.repository.PlaceRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
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
    private PlaceRepository placeRepository;
    @Autowired
    @Qualifier("placeApiRestTemplate")
    private RestTemplate restTemplate;

    // caching for 5 min -> caffeine -> redis // done
    // springdata mongodb
    // favori işaretleme endpointi
    // favorileri listeleyen endpoint getAll()
    // favori database'i
    // Angular önyüz


    @Cacheable("placeSearchCache")
    public List<Place> searchPlace(float latitude, float longitude, String username) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(SEARCH_URL)
                .queryParam("ll", latitude + "," + longitude); // uri


        PlaceResponse response = restTemplate.getForObject(builder.build().toUri(), PlaceResponse.class);

        List<Place> results = null;
        if (response != null) {
            results = response.getResults();
            results.forEach(place -> {
                log.info("Found a place: " + place + "\n Saving to database...");
                place.setCreatedBy(username);
                placeRepository.save(place); // favoriler silinir!!!
                    }
            );


        }


        return results;

    }

}
