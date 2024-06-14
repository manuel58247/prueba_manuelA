package com.example.prueba_manuelA.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class ReserveDto {
    @NotBlank(message= "El nombre del cliente no puede estar vacio")
    @Size(max=150,message= "El nombre del cliente debe ser maximo de150 caracteres")
    private String customerName;
    @NotBlank(message= "El numero del cliente")
    @Size(max=25, message= "El nombre del cliente debe ser maximo de 25 caracteres")
    @Pattern(regexp = "^\\d{8}$", message = "El número del cliente debe tener 8 dígitos")
    private String customerNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="No puede ser nulo la fecha")
    @FutureOrPresent(message="Debe ser igual o mayor a la fecha de hoy")
    private Date dateReserve;
    @NotBlank(message= "El estado de la reserva, no puede estar vacio")
    private String state;
    @NotBlank(message= "El menu de la reserva, no puede estar vacio")
    @Min(value = 1, message = "Seleccione un menu por favor")
    private Long idMenu;
}
