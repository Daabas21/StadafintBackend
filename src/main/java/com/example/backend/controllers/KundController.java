package com.example.backend.controllers;

import com.example.backend.entities.Kund;
import com.example.backend.repositories.KundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/kund")
public class KundController {

    @Autowired
    KundRepo kundRepo;

    @GetMapping
    public List<Kund> findAll(){
        return kundRepo.findAll();
    }
}
