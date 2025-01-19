package com.fviel.imob.real_state.entities;

import java.util.UUID;

import com.fviel.imob.person.entities.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="real_state", schema = "real_state")
@Data
@NoArgsConstructor
public class RealState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @Column(nullable=false, length=1024)
    private String address;

    @Column(nullable=false, length=1024)
    private boolean active;

    @Column(nullable=false, length=1024)
    private Double value; 

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private Person owner;        
}
