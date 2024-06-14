package com.example.prueba_manuelA.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity (name = "menu")
public class MenuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dinner")
    private Long idMenu;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean state;

    public MenuModel(MenuModel menuModel) {
        this.name = menuModel.getName();
        this.price = menuModel.getPrice();
        this.state = menuModel.getState();
    }
}