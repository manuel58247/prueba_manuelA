package com.example.prueba_manuelA.dto;

import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.model.MenuModel;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class MenuDinnerDto {
    @NotNull(message = "El ID del menú no puede ser nulo")
    private Long idMenu;
    @NotNull(message = "El ID de la cena no puede ser nulo")
    private Long idDinner;
    @Valid
    private DinnerModel dinnerModel;
}
