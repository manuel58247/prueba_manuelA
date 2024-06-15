package com.example.prueba_manuelA.controller;

import com.example.prueba_manuelA.dto.MenuDinnerDto;
import com.example.prueba_manuelA.model.MenuDinnerModel;
import com.example.prueba_manuelA.service.MenuDinnerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@RestController
@RequestMapping("/menudinner")
public class MenuDinnerController {
    @Autowired
    private MenuDinnerService iMenuDinnerService;

    @PostMapping
    public ResponseEntity<MenuDinnerModel> saveMenuDinner(@RequestBody @Valid MenuDinnerDto menuDinnerDto) {
        try {
            MenuDinnerModel savedMenuDinner = iMenuDinnerService.saveMenuDinner(menuDinnerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMenuDinner);
        } catch (EntityNotFoundException e) {
            // Manejar excepción si no se encuentra el menu o la cena
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<MenuDinnerModel>> getAllDinner(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(iMenuDinnerService.getAllMenuDinner(page, size));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MenuDinnerModel> editMenuDinner(@PathVariable ("id") UUID id, @RequestBody @Valid MenuDinnerDto menuDinnerDto) {
        MenuDinnerModel updatedMenuDinner = iMenuDinnerService.editMenuDinner(id,menuDinnerDto);
        return new ResponseEntity<>(updatedMenuDinner, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDinner(@PathVariable("id") UUID id) {
        iMenuDinnerService.deleteMenuDinner(id);
        return ResponseEntity.ok(!iMenuDinnerService.existById(id));
    }
}
