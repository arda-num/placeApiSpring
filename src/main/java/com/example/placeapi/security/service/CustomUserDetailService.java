package com.example.placeapi.security.service;

import com.example.placeapi.model.CustomUserDetail;
import com.example.placeapi.model.Customer;
import com.example.placeapi.repository.CustomerRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@CommonsLog
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = userRepository.findCustomerByUsername(username);
        if (customer.isEmpty()) {
            throw new UsernameNotFoundException(username);

        }
        return CustomUserDetail.build(customer.get());
    }
}