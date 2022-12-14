package com.example.backend.controllers;

import com.example.backend.entities.Customer;
import com.example.backend.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping
    public List<Customer> findAllCustomers(){
        return customerRepo.findAllCustomers();
    }

    @PostMapping
    public Customer registerUser(@RequestBody Customer customer){
        return customerRepo.registerUser(customer);
    }

}
