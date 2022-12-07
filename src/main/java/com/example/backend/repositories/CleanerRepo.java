package com.example.backend.repositories;

import com.example.backend.entities.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleanerRepo extends JpaRepository<Cleaner, Integer> {
}
