package com.example.prueba_manuelA.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
public class ReserveDto {
    @NotBlank(message= "El nombre del cliente no puede estar vacio")
    @Size(max=150,message= "El nombre del cliente debe ser maximo de 150 caracteres")
    private String customerName;
    @NotBlank(message= "El numero del cliente")
    @Size(max=25, message= "El nombre del cliente debe ser maximo de 25 caracteres")
    @Pattern(regexp = "^\\d{8}$", message = "El número del cliente debe tener 8 dígitos")
    private String customerNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="No puede ser nulo la fecha")
    @FutureOrPresent(message="Debe ser igual o mayor a la fecha de hoy")
    private Date dateReserve;
    @NotNull(message= "El estado de la reserva, no puede estar null")
    private Boolean state;
    private UUID idMenu;
}
