package com.example.backend.controllers;

import com.example.backend.entities.Cleaner;
import com.example.backend.entities.Customer;
import com.example.backend.entities.LoginDto;
import com.example.backend.repositories.CustomerRepo;
import com.example.backend.security.UserDetailsServiceImpl;
import com.example.backend.security.service.JwtUtils;
import com.example.backend.security.service.LoginService;
import com.example.backend.services.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class LoginController {

    @Autowired private LoginService loginService;
    @Autowired private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){
        return loginService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginDto jwtDTO){
        System.out.println(jwtDTO);
        return loginService.authenticate(jwtDTO.email(), jwtDTO.password());
    }

    @GetMapping("/details")
    public ResponseEntity<?> authDetails(Authentication auth) {
        if (auth != null) {
            UserDetails user = userDetailsService.loadUserByAuth(auth);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body(null);
        }

    }

}
