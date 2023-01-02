package com.example.backend.repositories;

import com.example.backend.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

    List<Booking> findByCleanerId(int id);

    List<Booking> findByCustomerId(int id);

    List<Booking> findByCleanerIdAndDateBetweenIgnoreCase(int id, Date startDate, Date endDate);
}
