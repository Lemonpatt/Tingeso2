package com.tingeso.ms_4.controllers;

import com.tingeso.ms_4.requests.SolicitudRequest;
import com.tingeso.ms_4.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evaluacion")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping("/")
    public ResponseEntity<List<String>> evaluarSolicitud(@RequestBody SolicitudRequest solicitudPrestamo) {
        List<String> resultados = evaluacionService.cumpleRequisitos(solicitudPrestamo);
        return ResponseEntity.ok(resultados);
    }

    @PostMapping("/costo-total")
    public ResponseEntity<List<String>> evaluarCostoTotal(@RequestBody SolicitudRequest solicitudPrestamo) {
        List<String> resultado = evaluacionService.TotalCostCredit(solicitudPrestamo);
        return ResponseEntity.ok(resultado);
    }
}
