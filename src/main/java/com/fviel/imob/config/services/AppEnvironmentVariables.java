package com.fviel.imob.config.services;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class AppEnvironmentVariables {

    private final Environment environment;

    public AppEnvironmentVariables(
        Environment environment){
        this.environment = environment;
    }
  
    public String getEnvironmentVariablesAsJson(){
        String java_home = environment.getProperty("java.home");
        String db_url = environment.getProperty("DB_URL");
        String response = "{\n"+
        "   $JAVA_HOME: " + java_home + "\n" +
        "   $DB_URL: " + db_url + "\n" +
        "}";
        return response;
    }
}
