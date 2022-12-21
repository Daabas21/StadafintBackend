package com.example.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.example.backend.entities.Role.CLEANER;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cleaner")
public class Cleaner implements UserDetails {

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
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    List<Role> roles = Collections.singletonList(CLEANER);

    public Cleaner(String name, String address, String telnum, String email, String password) {
        this.name = name;
        this.address = address;
        this.telnum = telnum;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+ role.toString()))
                .toList();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
