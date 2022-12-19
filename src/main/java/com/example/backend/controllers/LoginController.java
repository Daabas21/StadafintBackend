package com.example.backend.controllers;

import com.example.backend.entities.Customer;
import com.example.backend.entities.LoginDto;
import com.example.backend.repositories.CustomerRepo;
import com.example.backend.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer){
        return loginService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginDto jwtDTO){
        return loginService.authenticate(jwtDTO.email(), jwtDTO.password());
    }

}
