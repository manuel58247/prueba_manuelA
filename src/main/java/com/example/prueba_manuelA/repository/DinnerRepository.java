package com.example.prueba_manuelA.repository;

import com.example.prueba_manuelA.model.DinnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DinnerRepository extends JpaRepository<DinnerModel, UUID> {
}
