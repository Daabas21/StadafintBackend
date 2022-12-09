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
@Table(name = "kund")
public class Kund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kund_id")
    private int id;
    @Column(name = "kund_name")
    private String name;
    @Column(name = "kund_address")
    private String address;
    @Column(name = "kund_telnum")
    private String telnum;
    @Column(name = "kund_email")
    private String email;
    @Column(name = "kund_password")
    private String password;

}
