package com.example.prueba_manuelA.controller;

import com.example.prueba_manuelA.dto.DinnerDto;
import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.service.DinnerService;
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

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/dinner")
public class DinnerController {

    @Autowired
    private DinnerService dinnerService;

    @PostMapping
    public ResponseEntity<DinnerModel> saveDinner(@RequestBody @Valid DinnerDto dinnerDto) {
        DinnerModel savedDinner = dinnerService.saveDinner(dinnerDto);
        return new ResponseEntity<>(savedDinner, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<DinnerModel>> getAllDinner(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(dinnerService.getAllDinner(page, size));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDinner(@PathVariable("id") UUID id) {
        dinnerService.deleteDinner(id);
        return ResponseEntity.ok(!dinnerService.existById(id));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<DinnerModel>> findDinnerById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(dinnerService.findById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DinnerModel> editDinner(@PathVariable("id") UUID id,@RequestBody @Valid DinnerDto dinnerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dinnerService.editDinner(id, dinnerDto));
    }

}
