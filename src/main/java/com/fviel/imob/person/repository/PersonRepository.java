package com.fviel.imob.person.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fviel.imob.person.entities.Person;

public interface PersonRepository extends JpaRepository<Person, UUID>{
    
}
