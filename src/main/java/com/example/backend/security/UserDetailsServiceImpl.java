package com.example.backend.security;

import com.example.backend.entities.Cleaner;
import com.example.backend.entities.Customer;
import com.example.backend.repositories.CleanerRepo;
import com.example.backend.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CleanerRepo cleanerRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Cleaner> cleaner = cleanerRepo.findCleanerByEmail(email);
        Optional<Customer> customer = customerRepo.findCustomerByEmail(email);

        if (cleaner.isPresent()){
            return cleanerRepo.findCleanerByEmail(email).orElseThrow();
        }else {
            return customerRepo.findCustomerByEmail(email).orElseThrow();
        }

    }
}
