package com.tingeso.ms_5.services;

import com.tingeso.ms_5.DTO.SeguimientoDTO;
import com.tingeso.ms_5.repositories.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguimientoService {
    @Autowired
    private SeguimientoRepository seguimientoRepository;

    public SeguimientoDTO getSolicitudPrestamoById(Long id) {
        return seguimientoRepository.findById(id).orElse(null);
    }
}
