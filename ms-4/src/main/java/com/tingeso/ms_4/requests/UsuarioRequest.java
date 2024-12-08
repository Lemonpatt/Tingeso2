package com.tingeso.ms_4.requests;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class UsuarioRequest {
    private Long id;
    private String nombre;
    private String rut;
    private int edad;
    private int salario;
    private int saldoCuenta;
    private int antiguedadCuenta;
    private int deudaTotal;
    private String nombreArchivo;
    @Lob
    private String documento;
}
