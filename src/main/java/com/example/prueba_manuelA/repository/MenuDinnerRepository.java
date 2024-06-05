package com.example.prueba_manuelA.repository;

import com.example.prueba_manuelA.model.MenuDinnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDinnerRepository extends JpaRepository<MenuDinnerModel, Long> {
    @Query(value = "select d.id_dinner,d.name,description,d.price,m.id_menu,m.name,m.price,state from menudinner inner join dinner d on d.id_dinner = menudinner.id_dinner inner join menu m on menudinner.id_menu = m.id_menu;", nativeQuery = true)
    List<MenuDinnerModel> findAllByActivo();
}
