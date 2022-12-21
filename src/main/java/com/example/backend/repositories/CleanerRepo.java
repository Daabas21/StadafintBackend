package com.example.backend.repositories;

import com.example.backend.entities.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CleanerRepo extends JpaRepository<Cleaner, Integer> {

    Optional<Cleaner> findCleanerByEmail(String email);
}
