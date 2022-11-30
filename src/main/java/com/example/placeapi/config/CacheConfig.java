package com.example.placeapi.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Bean
    public Cache placeSearchCache() {
        return new CaffeineCache("placeSearchCache", Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build());

    }

    // add more caches here


}
