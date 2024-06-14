package com.example.prueba_manuelA.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.example.prueba_manuelA.model.DinnerModel;

@Data
@Entity (name = "menudinner")
public class MenuDinnerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_dinner", nullable = false)
    private Long idMenuDinner;
    @Column(name = "id_menu", nullable = false)
    private Long idMenu;
    @Column(name = "id_dinner", nullable = false)
    private Long idDinner;
    @NotNull(message="Es requerida el menu")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_menu_dinner_menu", nullable = false)
    private MenuModel menuModel;
    @NotNull(message="Es requerida la cena")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_menu_dinner_dinner", nullable = false)
    private DinnerModel dinnerModel;
}
