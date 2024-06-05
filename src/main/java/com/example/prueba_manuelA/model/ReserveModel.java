package com.example.prueba_manuelA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity(name ="reserve")
public class ReserveModel {
    final String vacio = " no puede ser vacio ni nulo";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserve;
    @NotBlank(message= "El nombre del cliente"+vacio)
    @NotNull (message= "El nombre del cliente"+vacio)
    @Size(min=5,max=50,message= "El nombre del cliente debe ser entre 5 y 50 caracteres")
    private String customer_name;
    @NotBlank(message= "El numero del cliente"+vacio)
    @NotNull (message= "El numero del cliente"+vacio)
    @Size(min=5,max=50,message= "El numero del cliente debe ser entre 5 y 50 caracteres")
    private int customer_number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="No puede ser nulo la fecha")
    @FutureOrPresent(message="Debe ser igual o mayor a la fecha de hoy")
    private Date date_reserve;
    @NotBlank(message= "El estado de la reserva"+vacio)
    @NotNull (message= "El estado de la reserva"+vacio)
    private String state;
    @NotBlank(message= "El menu de la reserva"+vacio)
    @NotNull (message= "El menu de la reserva"+vacio)
    @Min(value = 1, message = "Seleccione un menu por favor")
    private Long id_menu;

}
