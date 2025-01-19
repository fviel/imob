package com.fviel.imob.config.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * Gets values from the application.yaml
 * 
 spring:
  datasource:
    url: jdbc:postgresql://localhost:5440/imob
    username: sa_imob
    password: imob_pwd
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    show-sql: true
    properties:
      hibernate:
        format_sql: true
dotenv:
  enabled: true
  locations:
    - file:./.env
 */

@Service
public class AppProperties {
    
    @Value("${spring.datasource.url}")
    private String bdUrl;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlMode;

    @Value("${test.filesource}")
    private String filesource;

    public String toJson(){
        String resp = "{\n" +
        "   spring.datasource.url:" + bdUrl + "\n"+
        "   spring.jpa.hibernate.ddl-auto:" + ddlMode + "\n"+
        "   test.filesource:" + filesource + "\n"+
        "}";

        return resp;
    }

   
}