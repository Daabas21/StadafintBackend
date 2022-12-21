package com.example.backend.security.service;

import com.example.backend.entities.Customer;
import com.example.backend.repositories.CustomerRepo;
import com.example.backend.entities.StringToken;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private JwtUtils jwtUtils;
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;
    private CustomerRepo customerRepo;

    public LoginService(JwtUtils jwtUtils,
                        UserDetailsService userDetailsService,
                        PasswordEncoder passwordEncoder,
                        CustomerRepo customerRepo) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.customerRepo = customerRepo;
    }


    public ResponseEntity<?> registerCustomer(Customer customer) {
        //        String encodedPass = passwordEncoder.encode(customer.getPassword());
//        customer.setPassword(encodedPass);
        Customer existingCustomer = customerRepo.findCustomerByEmail(customer.getEmail()).orElseThrow();
        customer = customerRepo.save(customer);

        String token = jwtUtils.generateToken(customer.getEmail());
        return ResponseEntity.ok(token);
    }

    public ResponseEntity<?> authenticate(String email, String password) {

        try{

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            String token = jwtUtils.generateToken(email);
            return ResponseEntity.ok().body(new StringToken(token));
        } else {
            return ResponseEntity.status(401).body("password incorrect");
        }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Email not registered");
        }
    }

}
