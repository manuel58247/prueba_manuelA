package com.example.prueba_manuelA.model;

import com.example.prueba_manuelA.dto.ReserveDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name ="reserve")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReserveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_reserve", nullable = false)
    private UUID idReserve;
    @Column(name = "customer_name", nullable = false, length = 150)
    private String customerName;
    @Column(name = "customer_number", nullable = false, length = 25)
    private String customerNumber;
    @Column(name = "date_reserve", nullable = false)
    private Date dateReserve;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean state;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_reserve_menu", nullable = false)
    private MenuModel menuModel;

    public ReserveModel(ReserveDto reserveDto, MenuModel menuModel) {
        this.customerName = reserveDto.getCustomerName();
        this.customerNumber = reserveDto.getCustomerNumber();
        this.dateReserve = reserveDto.getDateReserve();
        this.state = reserveDto.getState();
        this.menuModel = menuModel;
    }
}
