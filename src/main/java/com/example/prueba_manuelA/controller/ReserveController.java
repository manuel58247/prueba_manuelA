package com.example.prueba_manuelA.controller;

import com.example.prueba_manuelA.dto.ReserveDto;
import com.example.prueba_manuelA.model.ReserveModel;
import com.example.prueba_manuelA.service.ReserveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
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
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping
    public ResponseEntity<ReserveModel> saveReserve( @RequestBody @Valid ReserveDto reserveDto) {
        ReserveModel saveReserveModel = reserveService.saveReserve(reserveDto);
        return new ResponseEntity<>(saveReserveModel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ReserveModel>> getAllReserve(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok(reserveService.getAllReserve(page, size));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletReserve(@PathVariable("id") UUID id) {
        reserveService.deleteReserve(id);
        return ResponseEntity.ok(!reserveService.existById(id));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ReserveModel>> findReservetById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(reserveService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReserveModel> editReserve(@PathVariable ("id") UUID id, @RequestBody @Valid ReserveDto reserveDto) {
        ReserveModel updatedMenuDinner = reserveService.editReserve(id,reserveDto);
        return new ResponseEntity<>(updatedMenuDinner, HttpStatus.CREATED);
    }
}
