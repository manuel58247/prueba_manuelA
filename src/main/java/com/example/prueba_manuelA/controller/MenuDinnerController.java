package com.example.prueba_manuelA.controller;

import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.model.MenuDinnerModel;
import com.example.prueba_manuelA.service.MenuDinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/menudinner")
public class MenuDinnerController {
    @Autowired
    private MenuDinnerService iMenuDinnerService;
//    @GetMapping()
//    public String inicio(Model model) {
//        try {
//            List<MenuDinnerModel> videojuegos = this.iMenuDinnerService.findAll();
//            model.addAttribute("videojuegos", videojuegos);
//
//            return "views/inicio";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "error";
//        }
//    }
    @GetMapping
    public ResponseEntity<Page<MenuDinnerModel>> getAllDinner (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(iMenuDinnerService.getAllMenuDinner(page, size));
    }
}
