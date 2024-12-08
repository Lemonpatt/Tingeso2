package com.tingeso.ms_1.DTO;

import jakarta.persistence.Entity;
import lombok.*;

@Data
public class SimulacionDTO {
    private int valorPropiedad;
    private int plazo;
    private double interes;
    private double financiamiento;
}
