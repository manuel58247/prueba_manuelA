package com.example.prueba_manuelA.repository;

import com.example.prueba_manuelA.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuModel, UUID> {
}
