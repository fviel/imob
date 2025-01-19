package com.fviel.imob.real_state.dtos;

import com.fviel.imob.person.entities.Person;

public record RealStateDto(String address,Double value,Person owner) {}
