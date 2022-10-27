package com.example.placeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PlaceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceApiApplication.class, args);
	}

}