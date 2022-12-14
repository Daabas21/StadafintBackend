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
    private String address;
    @Column(name = "cleaner_telnum")
    private String telnum;
    @Column(name = "cleaner_email")
    private String email;
    @Column(name = "cleaner_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Cleaner(String name, String address, String telnum, String email, String password) {
        this.name = name;
        this.address = address;
        this.telnum = telnum;
        this.email = email;
        this.password = password;
    }
}
