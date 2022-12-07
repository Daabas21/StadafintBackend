package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cleaner")
public class Cleaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cleaner_id")
    private int id;
    @Column(name = "cleaner_name")
    private String name;
    @Column(name = "cleaner_address")
    private String adrress;
    @Column(name = "cleaner_telnum")
    private String telnum;
    @Column(name = "cleaner_email")
    private String email;
    @Column(name = "cleaner_password")
    private String password;
}
