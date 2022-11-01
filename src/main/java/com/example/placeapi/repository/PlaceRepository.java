package com.example.placeapi.repository;

import com.example.placeapi.model.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place, String> { // Class, ID
}
