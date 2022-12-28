package com.example.backend.controllers;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Cleaner;
import com.example.backend.services.BookingService;
import com.example.backend.services.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cleaner")
public class CleanerController {

    @Autowired
    CleanerService cleanerService;

    @Autowired
    BookingService bookingService;

    @GetMapping("/{id}")
    public Cleaner findById(@PathVariable int id, Authentication auth){
        return cleanerService.findById(id, auth);
    }

    @PutMapping("/{id}")
    public Cleaner updateCleanerById(@PathVariable int id, @RequestBody Cleaner cleaner, Authentication auth) {
        return cleanerService.updateCleanerById(id, cleaner, auth);
    }

    @GetMapping("/{id}/booking")
    public List<Booking> findCleanerBooking(@PathVariable int id){
        return cleanerService.findCleanerBooking(id);
    }

    @PutMapping("/{id}/booking")
    public  Booking updateBookingByBookingId(@PathVariable int id) {
        return cleanerService.updateBookingByBookingId(id);
    }
}
