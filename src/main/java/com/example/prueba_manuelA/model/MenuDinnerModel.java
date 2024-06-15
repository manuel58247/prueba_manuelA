package com.example.prueba_manuelA.model;

import com.example.prueba_manuelA.dto.MenuDinnerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity (name = "menudinner")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDinnerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_menu_dinner", nullable = false)
    private UUID idMenuDinner;
    @NotNull(message="Es requerida el menu")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_menu_dinner_menu", nullable = false)
    private MenuModel menuModel;
    @NotNull(message="Es requerida la cena")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_menu_dinner_dinner", nullable = false)
    private DinnerModel dinnerModel;

    public MenuDinnerModel(MenuDinnerDto menuDinnerDto, MenuModel menuModel, DinnerModel dinnerModel) {
        this.menuModel = menuModel;
        this.dinnerModel = dinnerModel;
    }
}
