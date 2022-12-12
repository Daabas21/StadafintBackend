package com.example.backend.services;

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

    public List<Cleaner> findAll() {
        return cleanerRepo.findAll();
    }

    public Cleaner inserNewCleaner(Cleaner cleaner) {

        return cleanerRepo.save(cleaner);
    }
}
