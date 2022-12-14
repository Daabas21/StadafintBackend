package com.example.backend.security;

import com.example.backend.entities.Cleaner;
import com.example.backend.entities.Customer;
import com.example.backend.repositories.CleanerRepo;
import com.example.backend.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    CleanerRepo cleanerRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Cleaner> cleaner = cleanerRepo.findCleanerByEmail(email);
        Optional<Customer> customer = customerRepo.findCustomerByEmail(email);

        return customer.map(value -> User.builder()
                .username(value.getEmail())
                .password(value.getPassword())
                .authorities(new SimpleGrantedAuthority("CUSTOMER"))
                .build()).orElseGet(() -> cleaner.map(value -> User.builder()
                .username(value.getEmail())
                .password(value.getPassword())
                .authorities(new SimpleGrantedAuthority("ADMIN"))
                .build()).orElse(null));

    }
}