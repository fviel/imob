package com.fviel.imob.config;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

@Service
public class AppProperties {
    
    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @PostConstruct
    public void logProfile() {
        System.out.println("Active Spring Profile: " + activeProfile);
    }
}