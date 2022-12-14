package com.example.backend.controllers;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Customer;

import com.example.backend.services.BookingService;
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

    @Autowired
    BookingService bookingService;

    @GetMapping("/{id}")
    public Customer findById(@PathVariable int id, Authentication auth) {
        return customerService.findById(id, auth);
    }

    @GetMapping("/{id}/booking")
    public List<Booking> findCustomerBookingsById(Authentication auth) {
        return customerService.findCustomerBookingsById(auth);
    }

    @PostMapping
    public Customer insertNewCustomer(@RequestBody Customer customer) {
        return customerService.insertNewCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomerById(@PathVariable int id, @RequestBody Customer customer, Authentication auth){
        return customerService.updateCustomerById(id, customer, auth);
    }

    @PostMapping("/booking")
    public Booking insertNewBooking(@RequestBody Booking booking) {
        return bookingService.insertNewBooking(booking);
    }

    @DeleteMapping("/booking/{id}")
    public void deleteBookingById(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }

}
