package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.model.MenuModel;
import com.example.prueba_manuelA.repository.MenuRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MenuServise {
    @Autowired
    private MenuRepository iMenuRepository;

    public MenuModel saveMenu (MenuModel menu) {
        String idStr = String.valueOf(menu.getIdMenu());
        if (StringUtils.isNotBlank(idStr)) {
            return iMenuRepository.save(menu);
        }
        return null;
    }

    public Page<MenuModel> getAllMenu (Integer page, Integer size) {
        return iMenuRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteMenu (Long id){
        iMenuRepository.deleteById(id);
    }
    public Optional<MenuModel> findById(Long id){

        return iMenuRepository.findById(id);
    }
    public MenuModel editMenu (MenuModel menu){
        String idStr = String.valueOf(menu.getIdMenu());
        if (StringUtils.isNotBlank(idStr) && iMenuRepository.existsById(menu.getIdMenu())){
            return iMenuRepository.save(menu);
        }
        return null;
    }

    public boolean existById(Long id) {
        return iMenuRepository.existsById(id);
    }
}
