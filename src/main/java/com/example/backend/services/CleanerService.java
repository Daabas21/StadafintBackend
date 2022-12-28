package com.example.backend.services;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Cleaner;
import com.example.backend.repositories.BookingRepo;
import com.example.backend.repositories.CleanerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanerService {

    @Autowired
    CleanerRepo cleanerRepo;

    @Autowired
    BookingRepo bookingRepo;

    public int cleanerId(Authentication auth){
        String cleanerEmail = ((Cleaner) auth.getPrincipal()).getEmail();
        Cleaner cleaner = cleanerRepo.findCleanerByEmail(cleanerEmail).orElseThrow();

        return  cleaner.getId();
    }

    public Cleaner findById(int id, Authentication auth) {
        int cleanerId = cleanerId(auth);
        System.out.println(cleanerId);
//
        if (id == cleanerId) {
            return cleanerRepo.findById(id).orElseThrow();
        }else
            return cleanerRepo.findById(cleanerId).orElseThrow();
    }

    public Cleaner insertNewCleaner(Cleaner cleaner) {

        return cleanerRepo.save(cleaner);
    }

    public Cleaner updateCleanerById(int id, Cleaner cleaner, Authentication auth) {
        int cleanerId = cleanerId(auth);
        Cleaner existingCleaner = cleanerRepo.findById(cleanerId).orElseThrow();


        if (cleaner != null) {
            if (!cleaner.getName().equals("")) {
                existingCleaner.setName(cleaner.getName());
            }
            if (!cleaner.getAddress().equals("")) {
                existingCleaner.setAddress(cleaner.getAddress());
            }
            if (!cleaner.getTelnum().equals("")) {
                existingCleaner.setTelnum(cleaner.getTelnum());
            }
            if (!cleaner.getEmail().equals("")) {
                existingCleaner.setEmail(cleaner.getEmail());
            }
            if (!cleaner.getPassword().equals("")) {
                existingCleaner.setPassword(cleaner.getPassword());
            }
        return cleanerRepo.save(existingCleaner);
        }
        else{
            return null;
        }

    }

    public List<Booking> findCleanerBooking(int id) {
        return bookingRepo.findByCleanerId(id);
    }

    public List<Cleaner> findAllCleaners() {
        return cleanerRepo.findAll();
    }
}
