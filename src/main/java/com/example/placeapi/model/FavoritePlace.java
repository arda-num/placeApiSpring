package com.example.placeapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class FavoritePlace {

    private String placeID;
    private String userName;
    private String placeName;
    private LocalDateTime since;

}
