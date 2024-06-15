package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.dto.ReserveDto;
import com.example.prueba_manuelA.model.MenuModel;
import com.example.prueba_manuelA.model.ReserveModel;
import com.example.prueba_manuelA.repository.MenuRepository;
import com.example.prueba_manuelA.repository.ReserveRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReserveService {
    @Autowired
    private ReserveRepository iReserveRepository;
    @Autowired
    private MenuRepository iMenuRepository;

    public ReserveModel saveReserve(ReserveDto reserve) {
        MenuModel menuModel = iMenuRepository.findById(reserve.getIdMenu())
                .orElseThrow(() -> new EntityNotFoundException("Menu no encuentrado con id: " + reserve.getIdMenu()));

        return iReserveRepository.save(new ReserveModel(reserve, menuModel));
    }

    public Page<ReserveModel> getAllReserve(Integer page, Integer size) {
        return iReserveRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteReserve(UUID id) {
        iReserveRepository.deleteById(id);
    }

    public Optional<ReserveModel> findById(UUID id) {

        return iReserveRepository.findById(id);
    }
    public ReserveModel editReserve(@PathVariable UUID id, ReserveDto reserveDto) {
        ReserveModel reserveModel = iReserveRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserve not found with id: " + id));

        MenuModel menuModel = iMenuRepository.findById(reserveDto.getIdMenu())
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + reserveDto.getIdMenu()));
        reserveModel.setDateReserve(reserveDto.getDateReserve());
        reserveModel.setMenuModel(menuModel);
        reserveModel.setCustomerNumber(reserveDto.getCustomerNumber());
        reserveModel.setCustomerName(reserveDto.getCustomerName());
        reserveModel.setState(reserveDto.getState());

        return iReserveRepository.save(reserveModel);
    }

    public boolean existById(UUID id) {
        return iReserveRepository.existsById(id);
    }
}


