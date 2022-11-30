package com.example.placeapi.controller;


import com.example.placeapi.model.FavoritePlace;
import com.example.placeapi.model.Place;
import com.example.placeapi.model.PlaceId;
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
    public void setFavorite(@RequestBody PlaceId placeId) {
        Optional<Place> place = placeRepository.findPlaceByPlaceid(placeId);
        if (favoritedByRepository.existsByUserNameAndPlaceID(placeId.getUsername(), placeId.getFsqId())) {
            favoritedByRepository.deleteByUserNameAndPlaceID(placeId.getUsername(), placeId.getFsqId());
        } else {
            String placeName = place.get().getName();
            FavoritePlace favoritePlace = new FavoritePlace(placeId.getFsqId(), placeId.getUsername(), placeName, LocalDateTime.now());
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


