package com.example.prueba_manuelA.model;

import com.example.prueba_manuelA.dto.MenuDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity (name = "menu")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_menu")
    private UUID idMenu;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean state;

    public MenuModel(MenuDto menuDto) {
        this.name = menuDto.getName();
        this.price = menuDto.getPrice();
        this.state = menuDto.getState();
    }
}