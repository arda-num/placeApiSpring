package com.example.placeapi.repository;

import com.example.placeapi.model.FavoritePlace;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FavoritedByRepository extends MongoRepository<FavoritePlace, String> {

    Optional<FavoritePlace> findFavoritePlaceByPlaceIDAndUserName(String placeId, String UserName);

    List<FavoritePlace> findFavoritePlaceByUserName(String UserId);

}
