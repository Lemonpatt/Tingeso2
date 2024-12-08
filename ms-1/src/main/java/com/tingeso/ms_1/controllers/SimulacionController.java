package com.tingeso.ms_1.controllers;

import com.tingeso.ms_1.DTO.SimulacionDTO;
import com.tingeso.ms_1.services.SimulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/simulacion")
public class SimulacionController {
    @Autowired
    private SimulacionService simulacionService;

    @PostMapping("/")
    public double simulateCredit(@RequestBody SimulacionDTO request) {
        return simulacionService.simulateCredit(request);
    }
}
