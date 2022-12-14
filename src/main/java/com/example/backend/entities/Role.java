package com.example.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role",nullable = false)
    private String role;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<Cleaner> cleaners;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<Customer> customers;
}
