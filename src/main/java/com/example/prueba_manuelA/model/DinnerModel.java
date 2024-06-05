package com.example.prueba_manuelA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name ="dinner")
public class DinnerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dinner;
    @Size(min=3,max=50,message= "El nombre de la cena debe ser entre 5 y 50 caracteres")
    @NotBlank(message= "El nombre del menu no puede ser vacio ni nulo")
    @NotNull(message= "El nombre del menu no puede ser vacio ni nulo")
    private String name;
    @Size(min=1,max=50,message= "La descripcion de la cena debe ser entre 1 y 50 caracteres")
    @NotBlank(message= "La descripcion de la cena no puede ser vacia")
    @NotNull(message= "La descripcion de la cena no puede ser nula")
    @NotEmpty(message= "La descripcion de la cena no puede ser vacia")
    private String description;
    @NotNull ()
    private double price;
}
