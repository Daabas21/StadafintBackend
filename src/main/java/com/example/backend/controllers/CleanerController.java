package com.example.backend.controllers;

import com.example.backend.entities.Cleaner;
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
    public List<Cleaner> findAll() {
        return cleanerService.findAll();
    }

    @PostMapping
    public Cleaner insertNewCleaner(@RequestBody Cleaner cleaner) {
        return cleanerService.inserNewCleaner(cleaner);
    }
}
