package com.example.backend.services;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Cleaner;
import com.example.backend.repositories.BookingRepo;
import com.example.backend.repositories.CleanerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanerService {

    @Autowired
    CleanerRepo cleanerRepo;

    @Autowired
    BookingRepo bookingRepo;

    public Cleaner findById(int id) {
        return cleanerRepo.findById(id).orElseThrow();
    }

    public Cleaner insertNewCleaner(Cleaner cleaner) {

        return cleanerRepo.save(cleaner);
    }

    public Cleaner updateCleanerById(int id, Cleaner cleaner) {

        Cleaner existingCleaner = cleanerRepo.findById(id).orElseThrow();

        if (cleaner != null) {
            existingCleaner.setName(cleaner.getName());
            existingCleaner.setAddress(cleaner.getAddress());
            existingCleaner.setTelnum(cleaner.getTelnum());
            existingCleaner.setEmail(cleaner.getEmail());
            existingCleaner.setPassword(cleaner.getPassword());
        }

        return cleanerRepo.save(existingCleaner);
    }

    public List<Booking> findCleanerBooking(int id) {
        return bookingRepo.findByCleanerId(id);
    }

}
