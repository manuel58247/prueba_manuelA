package com.example.prueba_manuelA.service;

import com.example.prueba_manuelA.model.ReserveModel;
import com.example.prueba_manuelA.repository.ReserveRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReserveService {
    @Autowired
    private ReserveRepository iReserveRepository;

    public ReserveModel saveReserve (ReserveModel reserve) {
        String idStr = String.valueOf(reserve.getIdReserve());
        if (StringUtils.isNotBlank(idStr)) {
            return iReserveRepository.save(reserve);
        }
        return null;
    }

    public Page<ReserveModel> getAllReserve (Integer page, Integer size) {
        return iReserveRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteReserve(Long id){
        iReserveRepository.deleteById(id);
    }
    public Optional<ReserveModel> findById(Long id){

        return iReserveRepository.findById(id);
    }
    public ReserveModel editReserve (ReserveModel reserve){
        String idStr = String.valueOf(reserve.getIdReserve());
        if (StringUtils.isNotBlank(idStr) && iReserveRepository.existsById(reserve.getIdReserve())){
            return iReserveRepository.save(reserve);
        }
        return null;
    }

    public boolean existById(Long id) {
        return iReserveRepository.existsById(id);
    }
}
