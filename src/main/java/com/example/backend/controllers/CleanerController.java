package com.example.backend.controllers;

import com.example.backend.entities.Booking;
import com.example.backend.entities.Cleaner;
import com.example.backend.entities.Customer;
import com.example.backend.services.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cleaner")
public class CleanerController {

    @Autowired
    CleanerService cleanerService;

    @GetMapping
    public List<Cleaner> findAll(){
        return cleanerService.findAllCleaners();
    }

    @GetMapping("/{id}")
    public Cleaner findById(@PathVariable int id){
        return cleanerService.findById(id);
    }

    @PostMapping
    public Cleaner insertNewCleaner(@RequestBody Cleaner cleaner) {
        return cleanerService.insertNewCleaner(cleaner);
    }

    @PutMapping("/{id}")
    public Cleaner updateCleanerById(@PathVariable int id, @RequestBody Cleaner cleaner) {
        return cleanerService.updateCleanerById(id, cleaner);
    }

    @GetMapping("/{id}/booking")
    public List<Booking> findCleanerBooking(@PathVariable int id){
        return cleanerService.findCleanerBooking(id);
    }
}
