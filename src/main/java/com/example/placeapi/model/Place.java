package com.example.placeapi.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Place {
    @Id
    private PlaceId placeid;
    private String name;
    private String fsq_id;
    private Map<String, Object> extraData;

    @JsonAnyGetter
    public Map<String, Object> getExtraData() {
        return extraData;
    }

    @JsonAnySetter
    public void extraData(String key, Object data) {
        if (this.extraData == null) {
            this.extraData = new HashMap<>();
        }
        this.extraData.put(key, data);
    }

    private Boolean favorite = false; // favorite

}
