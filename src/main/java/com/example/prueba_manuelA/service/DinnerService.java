package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.dto.DinnerDto;
import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.repository.DinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DinnerService {
    @Autowired
    private DinnerRepository iDinnerRepository;

    public DinnerModel saveDinner(DinnerDto dinner) {
        return iDinnerRepository.save(new DinnerModel(dinner));
    }

    public Page<DinnerModel> getAllDinner(Integer page, Integer size) {
        return iDinnerRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteDinner(UUID id) {
        iDinnerRepository.deleteById(id);
    }

    public Optional<DinnerModel> findById(UUID id) {
        return iDinnerRepository.findById(id);
    }

    public DinnerModel editDinner(UUID id, DinnerDto dinner) {
        Optional<DinnerModel> existingDinnerOptional = iDinnerRepository.findById(id);

        if (existingDinnerOptional.isPresent()) {
            DinnerModel existingDinner = existingDinnerOptional.get();
            // Actualizar las propiedades del objeto existente con los datos del DTO
            existingDinner.setName(dinner.getName());
            existingDinner.setDescription(dinner.getDescription());
            existingDinner.setPrice(dinner.getPrice());
            // Guardar el objeto actualizado en la base de datos
            return iDinnerRepository.save(existingDinner);
        } else {
            return null; // Retorna null si no se encuentra el Dinner con el id dado
        }
    }

    public boolean existById(UUID id) {
        return iDinnerRepository.existsById(id);
    }
}
