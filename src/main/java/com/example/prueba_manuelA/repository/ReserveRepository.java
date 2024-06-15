package com.example.prueba_manuelA.repository;

import com.example.prueba_manuelA.model.ReserveModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReserveRepository  extends JpaRepository<ReserveModel, UUID> {
}
