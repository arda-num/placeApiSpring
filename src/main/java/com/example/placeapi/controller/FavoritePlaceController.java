package com.example.placeapi.controller;


import com.example.placeapi.model.FavoritePlace;
import com.example.placeapi.model.Place;
import com.example.placeapi.model.SetFavoriteQuery;
import com.example.placeapi.repository.FavoritedByRepository;
import com.example.placeapi.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/favorite")
@RestController
public class FavoritePlaceController {

    @Autowired
    private FavoritedByRepository favoritedByRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @PostMapping("/set")
    public void setFavorite(@RequestBody SetFavoriteQuery setFavoriteQuery) {
        Optional<Place> place = placeRepository.findPlaceByFsqIdAndCreatedBy(setFavoriteQuery.getPlaceid(), setFavoriteQuery.getUsername());
        if (favoritedByRepository.existsByUserNameAndPlaceID(setFavoriteQuery.getUsername(), setFavoriteQuery.getPlaceid())) {
            favoritedByRepository.deleteByUserNameAndPlaceID(setFavoriteQuery.getUsername(), setFavoriteQuery.getPlaceid());
        } else {
            String placeName = place.get().getName();
            FavoritePlace favoritePlace = new FavoritePlace(setFavoriteQuery.getPlaceid(), setFavoriteQuery.getUsername(), placeName, LocalDateTime.now());
            favoritedByRepository.insert(favoritePlace);
        }

    }

    @GetMapping("/getFavFromUser")
    public List<FavoritePlace> getFavoritePlacesFromUser(@RequestParam("username") String username) {
        return favoritedByRepository.findFavoritePlaceByUserName(username);
    }
    //@GetMapping
    //public List<Place> getAllFavorites(){
    //  return placeRepository.findBy
    // }

}


