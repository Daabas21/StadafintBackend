package com.example.backend.services;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Cleaner;
import com.example.backend.entities.Role;
import com.example.backend.repositories.BookingRepo;
import com.example.backend.repositories.CleanerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CleanerService {

    @Autowired
    CleanerRepo cleanerRepo;

    @Autowired
    BookingRepo bookingRepo;

    public int cleanerId(Authentication auth) {
        String cleanerEmail = ((Cleaner) auth.getPrincipal()).getEmail();
        Cleaner cleaner = cleanerRepo.findCleanerByEmail(cleanerEmail).orElseThrow();

        return cleaner.getId();
    }

    public Cleaner findById(int id, Authentication auth) {
        int cleanerId = cleanerId(auth);

        if (id == cleanerId) {
            return cleanerRepo.findById(id).orElseThrow();
        } else
            return cleanerRepo.findById(cleanerId).orElseThrow();
    }

    public Cleaner insertNewCleaner(Cleaner cleaner) {

        return cleanerRepo.save(cleaner);
    }

    public Cleaner updateCleanerById(int id, Cleaner cleaner, Authentication auth) {

        Cleaner existingCleaner;
        if (((Cleaner) auth.getPrincipal()).getRoles().contains(Role.ADMIN)) {
            existingCleaner = cleanerRepo.findById(id).orElseThrow();
        } else {
            int cleanerId = cleanerId(auth);
            existingCleaner = cleanerRepo.findById(cleanerId).orElseThrow();
        }


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
        } else {
            return null;
        }

    }

    public List<Booking> findCleanerBooking(int id) {
        return bookingRepo.findByCleanerId(id);
    }

    public List<Cleaner> findAllCleaners() {
        return cleanerRepo.findAll();
    }

    public Booking updateBookingByBookingId(int id) {

        Booking booking = bookingRepo.findById(id).orElseThrow();

        booking.setStatus("Performed");

        return bookingRepo.save(booking);
    }

    public List<Booking> findCleanerBookingByDate(int id, Date startDate, Date endDate, Authentication auth) {

        int cleanerId = cleanerId(auth);
        return bookingRepo.findByCleanerIdAndDateBetweenIgnoreCase(cleanerId, startDate, endDate);
    }

    public List<Booking> findCleanerBookingAuth(Authentication auth) {

        int cleanerId = cleanerId(auth);
        return  bookingRepo.findByCleanerId(cleanerId);
    }
}
