package com.example.placeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate placeApiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            HttpHeaders headers = request.getHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("Authorization", "fsq38jf5s6BtxsM5GasJ/3pdhr7HlOSL2O6cjpiwegCvd90="); // TODO
            return execution.execute(request, body);
        });
        return restTemplate;
    }

}
