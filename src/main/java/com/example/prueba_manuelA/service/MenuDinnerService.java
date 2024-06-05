package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.model.MenuDinnerModel;
import com.example.prueba_manuelA.repository.MenuDinnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuDinnerService {
    @Autowired
    private MenuDinnerRepository iMenuDinnerRepository;


    public Page<MenuDinnerModel> getAllMenuDinner (Integer page, Integer size) {
        return iMenuDinnerRepository.findAll(PageRequest.of(page, size));
    }
    @Transactional
    public List<MenuDinnerModel> findAll() throws Exception {
        try {
            List<MenuDinnerModel> entities = this.iMenuDinnerRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public MenuDinnerModel findById(long id) throws Exception {
        try {
            Optional<MenuDinnerModel> opt = this.iMenuDinnerRepository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<MenuDinnerModel> findAllByActivo() throws Exception{
        try {
            List<MenuDinnerModel> entities = this.iMenuDinnerRepository.findAllByActivo();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
//
//    public MenuDinnerModel saveMenu (MenuDinnerModel menu) {
//        String idStr = String.valueOf(menu.getId_menu());
//        if (StringUtils.isNotBlank(idStr)) {
//            return iMenuDinnerRepository.save(menu);
//        }
//        return null;
//    }
//
//    public Page<MenuDinnerModel> getAllMenu (Integer page, Integer size) {
//        return iMenuDinnerRepository.findAll(PageRequest.of(page, size));
//    }
//
//    public void deleteMenu (Long id){
//        iMenuDinnerRepository.deleteById(id);
//    }
//    public Optional<MenuDinnerModel> findById(Long id){
//
//        return iMenuDinnerRepository.findById(id);
//    }
//    public MenuDinnerModel editMenu (MenuDinnerModel menu){
//        String idStr = String.valueOf(menu.getId_menu());
//        if (StringUtils.isNotBlank(idStr) && iMenuDinnerRepository.existsById(menu.getId_menu())){
//            return iMenuDinnerRepository.save(menu);
//        }
//        return null;
//    }
//
//    public boolean existById(Long id) {
//        return iMenuDinnerRepository.existsById(id);
//    }
}
