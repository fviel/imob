package com.fviel.imob.person.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user", schema="person")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length=100)
    private String password;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();   

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;    
}
