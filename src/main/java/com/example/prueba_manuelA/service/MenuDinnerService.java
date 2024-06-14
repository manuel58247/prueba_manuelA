package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.model.MenuDinnerModel;
import com.example.prueba_manuelA.repository.MenuDinnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MenuDinnerService {
    @Autowired
    private MenuDinnerRepository iMenuDinnerRepository;


    public Page<MenuDinnerModel> getAllMenuDinner (Integer page, Integer size) {
        return iMenuDinnerRepository.findAll(PageRequest.of(page, size));
    }

    public List<MenuDinnerModel> findAll() throws Exception {
        try {
            List<MenuDinnerModel> entities = this.iMenuDinnerRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
     
    public MenuDinnerModel findById(long id) throws Exception {
        try {
            Optional<MenuDinnerModel> opt = this.iMenuDinnerRepository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

     
    public List<MenuDinnerModel> findAllByActivo() throws Exception{
        try {
            List<MenuDinnerModel> entities = this.iMenuDinnerRepository.findAllByActivo();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
