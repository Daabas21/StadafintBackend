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
    @Column(name = "customer_id")
    private int customerId;
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
    @Column(name= "working_time")
    private float workingTime;
    @Column(name = "service")
    private String service;

}
