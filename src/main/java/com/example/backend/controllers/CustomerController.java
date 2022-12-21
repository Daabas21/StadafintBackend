package com.example.backend.controllers;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Customer;

import com.example.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> findAll(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable int id, Authentication auth) {
        return customerService.findById(id, auth);
    }

    @GetMapping("/{id}/booking")
    public List<Booking> findCustomerBookingsById(@PathVariable int id) {
        return customerService.findCustomerBookingsById(id);
    }

    @PostMapping
    public Customer insertNewCustomer(@RequestBody Customer customer) {
        return customerService.insertNewCustomer(customer);
    }


    @PutMapping("/{id}")
    public Customer updateCustomerById(@PathVariable int id, @RequestBody Customer customer, Authentication auth){
        return customerService.updateCustomerById(id, customer, auth);
    }


}
