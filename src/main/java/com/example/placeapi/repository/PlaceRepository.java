package com.example.placeapi.repository;

import com.example.placeapi.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends MongoRepository<Place, String> { // Class, ID
    List<Place> findPlaceByCreatedBy(String username);

    Optional<Place> findPlaceByFsqIdAndCreatedBy(String id, String username);
}
