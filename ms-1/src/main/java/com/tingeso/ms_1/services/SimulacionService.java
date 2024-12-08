package com.tingeso.ms_1.services;

import com.tingeso.ms_1.DTO.SimulacionDTO;
import org.springframework.stereotype.Service;

@Service
public class SimulacionService {


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
