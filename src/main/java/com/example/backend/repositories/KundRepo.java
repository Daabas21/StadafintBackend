package com.example.backend.repositories;

import com.example.backend.entities.Kund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundRepo extends JpaRepository<Kund, Integer> {
}
