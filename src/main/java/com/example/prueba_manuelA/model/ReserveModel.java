package com.example.prueba_manuelA.model;

import com.example.prueba_manuelA.dto.ReserveDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity(name ="reserve")
public class ReserveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserve", nullable = false)
    private Long idReserve;
    @Column(name = "customer_name", nullable = false, length = 150)
    private String customerName;
    @Column(name = "customer_number", nullable = false, length = 25)
    private String customerNumber;
    @Column(name = "date_reserve", nullable = false)
    private Date dateReserve;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private String state;
    @Column(name = "id_menu", nullable = false)
    private Long idMenu;

    public ReserveModel(ReserveDto reserveDto) {
        this.customerName = reserveDto.getCustomerName();
        this.customerNumber = reserveDto.getCustomerNumber();
        this.dateReserve = reserveDto.getDateReserve();
        this.state = state;
        this.idMenu = idMenu;
    }
}
