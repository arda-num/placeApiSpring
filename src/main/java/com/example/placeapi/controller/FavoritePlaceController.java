package com.example.placeapi.controller;


import com.example.placeapi.model.FavoritePlace;
import com.example.placeapi.repository.FavoritedByRepository;
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

    @GetMapping("/set")
    public void setFavorite(@RequestParam("placeid") String placeId, @RequestParam("username") String userName) {
        FavoritePlace favoritePlace = new FavoritePlace(placeId, userName, LocalDateTime.now());
        favoritedByRepository.insert(favoritePlace);
    }

    @DeleteMapping("/delete")
    public void deleteFavorite(@RequestParam("placeid") String placeId, @RequestParam("username") String userName) {
        Optional<FavoritePlace> favoritePlace = favoritedByRepository.findFavoritePlaceByPlaceIDAndUserName(placeId, userName);
        favoritePlace.ifPresent(place -> favoritedByRepository.delete(place));
    }

    @GetMapping("/getFavFromUser")
    public List<FavoritePlace> getFavoritePlacesFromUser(@RequestParam("username") String userName) {
        return favoritedByRepository.findFavoritePlaceByUserName(userName);
    }
    //@GetMapping
    //public List<Place> getAllFavorites(){
    //  return placeRepository.findBy
    // }

}


