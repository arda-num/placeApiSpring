package com.example.placeapi.repository;

import com.example.placeapi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findCustomerByUsername(String username);

    Boolean existsByUsername(String userName);

}
