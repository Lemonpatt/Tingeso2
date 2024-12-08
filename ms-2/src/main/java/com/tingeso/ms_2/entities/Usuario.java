package com.tingeso.ms_2.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "usuario")

public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String rut;
    private int edad;
    private int salario;
    private int saldoCuenta;
    private int antiguedadCuenta;
    private int deudaTotal;
    private String nombreArchivo;
    @Getter
    @Lob
    private String documento;

    public Usuario(Long id, String nombre, String rut, int edad, int salario, int saldoCuenta, int antiguedadCuenta, int deudaTotal, String nombreArchivo, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.salario = salario;
        this.saldoCuenta = saldoCuenta;
        this.antiguedadCuenta = antiguedadCuenta;
        this.deudaTotal = deudaTotal;
        this.nombreArchivo = nombreArchivo;
        this.documento = documento;
    }

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getDeudaTotal() {
        return deudaTotal;
    }

    public void setDeudaTotal(int deudaTotal) {
        this.deudaTotal = deudaTotal;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(int saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public int getAntiguedadCuenta() {
        return antiguedadCuenta;
    }

    public void setAntiguedadCuenta(int antiguedadCuenta) {
        this.antiguedadCuenta = antiguedadCuenta;
    }

}
