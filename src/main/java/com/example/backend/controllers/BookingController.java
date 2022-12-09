package com.example.backend.controllers;

import com.example.backend.entities.Booking;
import com.example.backend.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingRepo bookingRepo;

    @GetMapping
    public List<Booking> findAll(){
        return bookingRepo.findAll();
    }

}
