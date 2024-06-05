package com.example.prueba_manuelA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity (name = "menu")
public class MenuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_menu;
    @NotBlank(message= "El nombre del menu no puede ser vacio ni nulo" )
    @NotNull(message= "El nombre del menu no puede ser vacio ni nulo")
    @Size(min=5,max=50,message= "El nombre del menu debe ser entre 5 y 50 caracteres")
    private String name;
//    @DecimalMin(value = "0.01", message = "El valor minimo ingresado debe ser mayor a 0.01")
//    @Digits(integer = 6, fraction = 2, message = "Maximo precio de 6 cifras y de 2 decimales")
    private double price;
    private String state;
}