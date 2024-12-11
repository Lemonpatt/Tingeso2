package com.tingeso.ms_5.services;


import com.tingeso.ms_5.requests.SolicitudRequest;

import com.tingeso.ms_5.clients.SolicitudFeignClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SeguimientoService {

    private final SolicitudFeignClient solicitudClient;

    public SeguimientoService(SolicitudFeignClient solicitudClient) {
        this.solicitudClient = solicitudClient;
    }
    public List<String> getSeguimiento(Long id) {
        List<String> seguimiento = new ArrayList<>();
        SolicitudRequest solicitud = solicitudClient.getSolicitudById(id);

        String estado = solicitud.getEstado();

        if (Objects.equals(estado, "Pendiente de Documentación")){
            seguimiento.add("Vista de Cliente");
            seguimiento.add("Su solicitud no procederá hasta que haya provisto todos los documentos pedidos");
        }
        else if (Objects.equals(estado, "En evaluación")){
            seguimiento.add("Vista de Ejecutivo");
            seguimiento.add("Se evalúa la solicitud en primera instancia");
        }
        else if (Objects.equals(estado, "Pre-Aprobada")){
            seguimiento.add("Vista de Cliente");
            seguimiento.add("Su solicitud Cumple los criterios básicos, a continuación se presentan las condiciones iniciales del crédito");
        }
        else if (Objects.equals(estado, "En Aprobación Final")){
            seguimiento.add("Vista de Ejecutivo");
            seguimiento.add("El cliente aceptó las condiciones, revisar detalles finales");
        }
        else if (Objects.equals(estado, "Aprobada")){
            seguimiento.add("Vista de Cliente");
            seguimiento.add("La solicitud ha sido aprobada, el proceso de desembolso empezará en las siguientes semanas");
        }
        else if (Objects.equals(estado, "En Desembolso")){
            seguimiento.add("Vista de Ejecutivo");
            seguimiento.add("La solicitud se encuentra en el proceso de desembolso");
        }

        return seguimiento;


    }
}
