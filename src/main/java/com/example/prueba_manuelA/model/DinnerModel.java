package com.example.prueba_manuelA.model;

import com.example.prueba_manuelA.dto.DinnerDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

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
