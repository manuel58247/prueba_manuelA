package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.dto.MenuDto;
import com.example.prueba_manuelA.model.MenuModel;
import com.example.prueba_manuelA.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class MenuServise {
    @Autowired
    private MenuRepository iMenuRepository;

    public MenuModel saveMenu(MenuDto menu) {
        return iMenuRepository.save(new MenuModel(menu));
    }

    public Page<MenuModel> getAllMenu(Integer page, Integer size) {
        return iMenuRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteMenu(UUID id) {
        iMenuRepository.deleteById(id);
    }

    public Optional<MenuModel> findById(UUID id) {

        return iMenuRepository.findById(id);
    }

    public MenuModel editMenu(@PathVariable UUID id, MenuDto menu) {
        Optional<MenuModel> existingDinnerOptional = iMenuRepository.findById(id);

        if (existingDinnerOptional.isPresent()) {
            MenuModel existingMenu = existingDinnerOptional.get();
            // Actualizar las propiedades del objeto existente con los datos del DTO
            existingMenu.setName(menu.getName());
            existingMenu.setPrice(menu.getPrice());
            existingMenu.setState(menu.getState());
            // Guardar el objeto actualizado en la base de datos
            return iMenuRepository.save(existingMenu);
        } else {
            return null; // Retorna null si no se encuentra el Dinner con el id dado
        }
    }

    public boolean existById(UUID id) {
        return iMenuRepository.existsById(id);
    }
}
