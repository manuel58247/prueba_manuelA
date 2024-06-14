package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.dto.DinnerDto;
import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.repository.DinnerRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class DinnerService {
    @Autowired
    private DinnerRepository iDinnerRepository;

    public DinnerModel saveDinner (DinnerDto dinner) {
            return iDinnerRepository.save(new DinnerModel(dinner));
    }

    public Page<DinnerModel> getAllDinner (Integer page, Integer size) {
        return iDinnerRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteDinner(Long id){
        iDinnerRepository.deleteById(id);
    }
    public Optional<DinnerModel> findById(Long id){

        return iDinnerRepository.findById(id);
    }
    public DinnerModel editDinner (@PathVariable UUID id, DinnerModel dinner){
//        String idStr = String.valueOf(dinner.getIdDinner());
//        if (StringUtils.isNotBlank(idStr) && iDinnerRepository.existsById(dinner.getIdDinner())){
//            return iDinnerRepository.save(dinner);
//        }
        dinner.setIdDinner(id);
        return iDinnerRepository.save(dinner);
    }

    public boolean existById(Long id) {
        return iDinnerRepository.existsById(id);
    }

}
