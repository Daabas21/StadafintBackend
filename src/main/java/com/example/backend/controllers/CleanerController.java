package com.example.backend.controllers;

import com.example.backend.entities.Cleaner;
import com.example.backend.repositories.CleanerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cleaner")
public class CleanerController {

    @Autowired
    CleanerRepo cleanerRepo;

    @GetMapping
    public List<Cleaner> Cleaners() {
        return cleanerRepo.findAll();
    }
}
