package com.example.prueba_manuelA.model;

import com.example.prueba_manuelA.dto.DinnerDto;
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
@Entity(name = "dinner")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DinnerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_dinner", nullable = false)
    private UUID idDinner;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;

    public DinnerModel(DinnerDto dinnerDto) {
        this.name = dinnerDto.getName();
        this.description =  dinnerDto.getDescription();
        this.price = dinnerDto.getPrice();
    }

}
