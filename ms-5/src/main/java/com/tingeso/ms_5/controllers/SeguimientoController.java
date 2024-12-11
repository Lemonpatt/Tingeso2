package com.tingeso.ms_5.controllers;


import com.tingeso.ms_5.services.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seguimiento")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @GetMapping("/{id}")
    public List<String> getSeguimiento(@PathVariable Long id) {
        List<String> solicitud = seguimientoService.getSeguimiento(id);
        return solicitud;
    }
}
