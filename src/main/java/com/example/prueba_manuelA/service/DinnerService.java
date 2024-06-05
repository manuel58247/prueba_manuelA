package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.model.DinnerModel;
import com.example.prueba_manuelA.repository.DinnerRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DinnerService {
    @Autowired
    private DinnerRepository iDinnerRepository;

    public DinnerModel saveDinner (DinnerModel dinner) {
        String idStr = String.valueOf(dinner.getId_dinner());
        if (StringUtils.isNotBlank(idStr)) {
            return iDinnerRepository.save(dinner);
        }
        return null;
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
    public DinnerModel editDinner (DinnerModel dinner){
        String idStr = String.valueOf(dinner.getId_dinner());
        if (StringUtils.isNotBlank(idStr) && iDinnerRepository.existsById(dinner.getId_dinner())){
            return iDinnerRepository.save(dinner);
        }
        return null;
    }

    public boolean existById(Long id) {
        return iDinnerRepository.existsById(id);
    }
}
