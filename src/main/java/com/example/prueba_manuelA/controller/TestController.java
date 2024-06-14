package com.example.prueba_manuelA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test")
    public String testConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Conexión exitosa a PostgreSQL";
        } catch (Exception e) {
            return "Error al conectar a PostgreSQL: " + e.getMessage();
        }
    }
}