package com.tingeso.ms_3.controllers;

import com.tingeso.ms_3.entities.Solicitud;
import com.tingeso.ms_3.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;



    @PostMapping("/crear")
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud solicitud) {

        Solicitud nuevaSolicitud = solicitudService.crearSolicitud(solicitud);
        return ResponseEntity.ok(nuevaSolicitud);
    }

    @PutMapping("/update")
    public ResponseEntity<String> saveSolicitud(@RequestBody Solicitud solicitudPrestamo) {
        solicitudService.updateSolicitud(solicitudPrestamo);
        return ResponseEntity.ok("Solicitud actualizada con éxito.");
    }

    @GetMapping("/")
    public ResponseEntity<List<Solicitud>> listSolicitudes() {
        List<Solicitud> solicitudes = solicitudService.getSolicitudes();
        return ResponseEntity.ok(solicitudes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {

        solicitudService.deleteSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}
