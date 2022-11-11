package com.example.placeapi.repository;

import com.example.placeapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByUserName(String userName);

    Boolean existsByUserName(String userName);

}
