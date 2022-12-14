package com.example.backend.controllers;

import com.example.backend.entities.Booking;
import com.example.backend.repositories.BookingRepo;
import com.example.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping
    public List<Booking> findAll(){
        return bookingService.findAllBookings();
    }

    @GetMapping("/{id}")
    public Booking findById(@PathVariable int id){
        return bookingService.findById(id);
    }

    @PostMapping
    public Booking insertNewBooking(@RequestBody Booking booking) {
        return bookingService.insertNewBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBookingById(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBookingById(id, booking);
    }

}
