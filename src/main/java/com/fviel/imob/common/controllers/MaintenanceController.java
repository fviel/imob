package com.fviel.imob.common.controllers;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fviel.imob.config.AppProperties;

@RestController
@RequestMapping(value = "/imob/maintenance")
public class MaintenanceController {


    private final Environment environment;
    private AppProperties appProperties;

    public MaintenanceController(

        Environment environment,
        AppProperties appProperties){
        this.environment = environment;
        this.appProperties = appProperties;
    }

    @RequestMapping(value = "/v1/ping", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");        
    }

    /**
     * Gets data from environment vars, like $JAVA_HOME
     * @return
     */
    @RequestMapping(value = "/v1/env", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getEnvironmentData() {
        String java_home = environment.getProperty("java.home");
        return ResponseEntity.ok("{\nJAVA_HOME: " + java_home);        
    }

    /**
     * Gets data from application.yml
     * @return
     */
    @RequestMapping(value = "/v1/prop", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getApplicationPropertyData() {
        String props = appProperties.toString();
        return ResponseEntity.ok(props);
    }

    
} 