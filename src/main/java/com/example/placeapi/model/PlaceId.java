package com.example.placeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceId {
    private String username;
    @JsonProperty("fsq_id")
    private String fsqId;

}


