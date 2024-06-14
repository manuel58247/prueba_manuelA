package com.example.prueba_manuelA.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DinnerDto {
    @NotBlank(message = "La descripcion de la cena no puede ser vacia")
    private String name;
    @NotBlank(message = "La descripcion de la cena no puede ser vacia")
    private String description;
    @NotNull(message = "El precio de la cena no puede ser vacia")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo")
    private BigDecimal price;
}