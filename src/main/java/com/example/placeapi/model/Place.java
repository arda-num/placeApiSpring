package com.example.placeapi.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @JsonProperty("fsq_id")
    private String fsqId;
    private String name;
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
}
