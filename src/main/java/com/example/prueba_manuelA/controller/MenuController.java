package com.example.prueba_manuelA.controller;

import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.model.MenuModel;
import com.example.prueba_manuelA.service.MenuServise;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuServise menuServise;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public ResponseEntity<MenuModel> saveMenu (@Valid @RequestBody MenuModel menuModel, BindingResult bindingResult) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuServise.saveMenu(menuModel));
    }

    @GetMapping
    public ResponseEntity<Page<MenuModel>> getAllMenu (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(menuServise.getAllMenu(page, size));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMenu(@PathVariable ("id") Long id){
        menuServise.deleteMenu(id);
        return ResponseEntity.ok(!menuServise.existById(id));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<MenuModel>> findMenuById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(menuServise.findById(id));
    }
    @PutMapping
    public ResponseEntity<MenuModel> editMenu (@RequestBody MenuModel reserveModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuServise.editMenu(reserveModel));
    }
}
