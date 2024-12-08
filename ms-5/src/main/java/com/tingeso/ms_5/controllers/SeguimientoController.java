package com.tingeso.ms_5.controllers;

import com.tingeso.ms_5.DTO.SeguimientoDTO;
import com.tingeso.ms_5.services.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seguimiento")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoDTO> getSolicitudById(@PathVariable Long id) {
        SeguimientoDTO solicitud = seguimientoService.getSolicitudPrestamoById(id);
        return ResponseEntity.ok(solicitud);
    }
}
