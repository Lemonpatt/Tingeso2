package com.tingeso.ms_1.services;

import com.tingeso.ms_1.DTO.SimulacionDTO;
import com.tingeso.ms_1.repositories.SimulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulacionService {
    @Autowired
    private SimulacionRepository simulacionRepository;

    public double simulateCredit(SimulacionDTO request) {
        double montoPrestamo;
        if (request.getFinanciamiento() != 0) {
            montoPrestamo = request.getValorPropiedad() * request.getFinanciamiento()/100;
        } else {
            montoPrestamo = request.getValorPropiedad();
        }
        int pagos = request.getPlazo() * 12;
        double tasaInteresMensual = request.getInteres() / 12 / 100;

        // Fórmula para calcular la cuota mensual

        return montoPrestamo * ((tasaInteresMensual * Math.pow(1 + tasaInteresMensual, pagos)) /
                (Math.pow(1 + tasaInteresMensual, pagos) - 1));
    }
}
