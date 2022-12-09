package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;
    @Column(name = "cleaner_id")
    private int cleanerId;
    @Column(name = "kund_id")
    private int kundId;
    @Column(name = "booking_description")
    private String description;
    @Column(name = "booking_address")
    private String address;
    @Column(name = "booking_date")
    private Date date;
    @Column(name = "booking_time")
    private Time time;
    @Column(name = "booking_status")
    private String status;

}
