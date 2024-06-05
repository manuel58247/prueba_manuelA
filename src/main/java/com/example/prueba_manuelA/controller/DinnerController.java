package com.example.prueba_manuelA.controller;

import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.model.MessageModel;
import com.example.prueba_manuelA.service.DinnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dinner")
public class DinnerController {

    @Autowired
    private DinnerService dinnerService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public ResponseEntity<MessageModel> saveDinner (@Valid @RequestBody DinnerModel dinnerModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new MessageModel("Revise los campos"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new MessageModel("Creado correctamente"),HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.CREATED).body(dinnerService.saveDinner(dinnerModel));
    }

    @GetMapping
    public ResponseEntity<Page<DinnerModel>> getAllDinner (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(dinnerService.getAllDinner(page, size));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable ("id") Long id){
        dinnerService.deleteDinner(id);
        return ResponseEntity.ok(!dinnerService.existById(id));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<DinnerModel>> findStudentById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(dinnerService.findById(id));
    }
    @PutMapping
    public ResponseEntity<DinnerModel> editStudent (@RequestBody DinnerModel student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dinnerService.editDinner(student));
    }

}
