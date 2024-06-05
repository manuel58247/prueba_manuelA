package com.example.prueba_manuelA.controller;

import com.example.prueba_manuelA.model.ReserveModel;
import com.example.prueba_manuelA.service.ReserveService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/service")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public ResponseEntity<ReserveModel> saveDinner (@Valid @RequestBody ReserveModel reserveModel, BindingResult bindingResult) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reserveService.saveReserve(reserveModel));
    }

    @GetMapping
    public ResponseEntity<Page<ReserveModel>> getAllDinner (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(reserveService.getAllReserve(page, size));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteStudent(@PathVariable ("id") Long id){
        reserveService.deleteReserve(id);
        return ResponseEntity.ok(!reserveService.existById(id));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ReserveModel>> findStudentById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reserveService.findById(id));
    }
    @PutMapping
    public ResponseEntity<ReserveModel> editStudent (@RequestBody ReserveModel reserveModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reserveService.editReserve(reserveModel));
    }
}
