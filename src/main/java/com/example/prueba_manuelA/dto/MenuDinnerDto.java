package com.example.prueba_manuelA.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;
@Data
public class MenuDinnerDto {
    @NotNull(message = "El id del menú no puede ser nulo")
    private UUID idMenu;
    @NotNull(message = "El id de la cena no puede ser nulo")
    private UUID idDinner;
}
