package com.example.backend.services;

import com.example.backend.entities.Booking;
import com.example.backend.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    public List<Booking> findAllBookings() {
        return bookingRepo.findAll();
    }

    public Booking findById(int id) {
        return bookingRepo.findById(id).orElseThrow();
    }

    public Booking insertNewBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    //TODO - Annika, fill in with needed data
    public Booking updateBookingById(int id, Booking booking) {
        return booking;
    }


    public void deleteBooking(int id){
        bookingRepo.deleteById(id);
    }
}
