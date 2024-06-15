package com.example.prueba_manuelA.service;
import com.example.prueba_manuelA.dto.MenuDinnerDto;
import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.model.MenuDinnerModel;
import com.example.prueba_manuelA.model.MenuModel;
import com.example.prueba_manuelA.repository.DinnerRepository;
import com.example.prueba_manuelA.repository.MenuDinnerRepository;
import com.example.prueba_manuelA.repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class MenuDinnerService {
    @Autowired
    private MenuDinnerRepository menuDinnerRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private DinnerRepository dinnerRepository;


    public MenuDinnerModel saveMenuDinner(MenuDinnerDto menuDinnerDto) {
        // Buscar el menu por su ID
        MenuModel menuModel = menuRepository.findById(menuDinnerDto.getIdMenu()).orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + menuDinnerDto.getIdMenu()));

        // Buscar la cena por su ID
        DinnerModel dinnerModel = dinnerRepository.findById(menuDinnerDto.getIdDinner()).orElseThrow(() -> new EntityNotFoundException("Dinner not found with id: " + menuDinnerDto.getIdDinner()));

        // Crear y guardar el nuevo registro en menudinner
        MenuDinnerModel menuDinnerModel = new MenuDinnerModel(menuDinnerDto, menuModel, dinnerModel);
        return menuDinnerRepository.save(menuDinnerModel);
    }

    public Page<MenuDinnerModel> getAllMenuDinner(Integer page, Integer size) {
        return menuDinnerRepository.findAll(PageRequest.of(page, size));
    }
    public MenuDinnerModel editMenuDinner(@PathVariable UUID id, MenuDinnerDto menuDinnerDto) {
        MenuDinnerModel menuDinnerModel = menuDinnerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("MenuDinner no encontrado con id: " + menuDinnerDto.getIdMenu()));
        // Buscar el menu por su ID
        MenuModel menuModel = menuRepository.findById(menuDinnerDto.getIdMenu()).orElseThrow(() -> new EntityNotFoundException("Menu no encontrado con id: " + menuDinnerDto.getIdMenu()));

        // Buscar la cena por su ID
        DinnerModel dinnerModel = dinnerRepository.findById(menuDinnerDto.getIdDinner()).orElseThrow(() -> new EntityNotFoundException("Dinner no encontrado con id: " + menuDinnerDto.getIdDinner()));
        menuDinnerModel.setDinnerModel(dinnerModel);
        menuDinnerModel.setMenuModel(menuModel);
        return menuDinnerRepository.save(menuDinnerModel);
    }
    public boolean existById(UUID id) {
        return menuDinnerRepository.existsById(id);
    }

    public void deleteMenuDinner(UUID id) {
        menuDinnerRepository.deleteById(id);
    }
}