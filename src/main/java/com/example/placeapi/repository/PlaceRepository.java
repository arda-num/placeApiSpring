package com.example.placeapi.repository;

import com.example.placeapi.model.Place;
import com.example.placeapi.model.PlaceId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlaceRepository extends MongoRepository<Place, PlaceId> { // Class, ID

    Optional<Place> findPlaceByPlaceid(PlaceId placeid);
}
