package com.fviel.imob.common.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fviel.imob.config.services.AppEnvironmentVariables;
import com.fviel.imob.config.services.AppProperties;

@RestController
@RequestMapping(value = "/imob/maintenance")
public class MaintenanceController {


    private final AppEnvironmentVariables appEnvironmentVariables;
    private final AppProperties appProperties;

    public MaintenanceController(
        AppEnvironmentVariables appEnvironmentVariables,
        AppProperties appProperties){
        this.appEnvironmentVariables = appEnvironmentVariables;
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
        String envs = appEnvironmentVariables.getEnvironmentVariablesAsJson();
        return ResponseEntity.ok(envs);        
    }

    /**
     * Gets data from application.yml
     * @return
     */
    @RequestMapping(value = "/v1/prop", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getApplicationPropertyData() {
        String props = appProperties.toJson();
        return ResponseEntity.ok(props);
    }    
} 