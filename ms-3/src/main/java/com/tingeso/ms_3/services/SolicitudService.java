package com.tingeso.ms_3.services;

import com.tingeso.ms_3.entities.Solicitud;
import com.tingeso.ms_3.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    public Solicitud crearSolicitud(Solicitud solicitud) {

        return solicitudRepository.save(solicitud);

    }

    public List<Solicitud> getSolicitudes() {
        return solicitudRepository.findAll();
    }

    public Solicitud updateSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public void deleteSolicitud(Long id) {

        solicitudRepository.deleteById(id);

    }
}
