package com.example.prueba_manuelA.repository;

import com.example.prueba_manuelA.model.MenuDinnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuDinnerRepository extends JpaRepository<MenuDinnerModel, UUID> {
}
