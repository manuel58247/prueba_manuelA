package com.example.prueba_manuelA.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Digits;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuDto {
    @NotBlank(message= "El nombre del menu no puede ser vacio")
    @Size(min=1,max=150,message= "El nombre del menu debe ser entre 1 y 150 caracteres")
    private String name;
    //    @DecimalMin(value = "0.01", message = "El valor minimo ingresado debe ser mayor a 0.01")
//    @Digits(integer = 6, fraction = 2, message = "Maximo precio de 6 cifras y de 2 decimales")
    @NotNull(message = "El precio de la cena no puede ser vacia")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo, valor minimo a ingresar debe ser mayor a 0.01")
    @Digits(integer = 6, fraction = 2, message = "Maximo del precio de 6 cifras y de 2 decimales")
    private BigDecimal price;
    @NotNull(message = "El estado del menu no puede ser nulo")
    private String state;


}
