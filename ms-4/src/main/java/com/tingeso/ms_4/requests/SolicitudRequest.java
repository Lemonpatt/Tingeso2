package com.tingeso.ms_4.requests;

import java.util.List;

public class SolicitudRequest {

    private int valorPropiedad;


    private String tipoPrestamo;

    private int antiguedadTrabajo;

    private String tipoTrabajo;

    private int plazo;

    private double interes;

    private double seguroDegravamen;

    private int seguroIncendio;

    private double comision;

    private double financiamiento;

    private double cuotaMensual;


    private List<Double> ingresosMensuales;


    private List<Double> deudasMensuales;

    private Long usuario;

    public SolicitudRequest() {
    }

    public SolicitudRequest(int valorPropiedad, String tipoPrestamo, int antiguedadTrabajo, String tipoTrabajo, int plazo, double interes, double seguroDegravamen, int seguroIncendio, double comision, double financiamiento, double cuotaMensual, List<Double> ingresosMensuales, List<Double> deudasMensuales, Long usuario) {
        this.valorPropiedad = valorPropiedad;
        this.tipoPrestamo = tipoPrestamo;
        this.antiguedadTrabajo = antiguedadTrabajo;
        this.tipoTrabajo = tipoTrabajo;
        this.plazo = plazo;
        this.interes = interes;
        this.seguroDegravamen = seguroDegravamen;
        this.seguroIncendio = seguroIncendio;
        this.comision = comision;
        this.financiamiento = financiamiento;
        this.cuotaMensual = cuotaMensual;
        this.ingresosMensuales = ingresosMensuales;
        this.deudasMensuales = deudasMensuales;
        this.usuario = usuario;
    }

    public int getValorPropiedad() {
        return valorPropiedad;
    }

    public void setValorPropiedad(int valorPropiedad) {
        this.valorPropiedad = valorPropiedad;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public int getAntiguedadTrabajo() {
        return antiguedadTrabajo;
    }

    public void setAntiguedadTrabajo(int antiguedadTrabajo) {
        this.antiguedadTrabajo = antiguedadTrabajo;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getSeguroDegravamen() {
        return seguroDegravamen;
    }

    public void setSeguroDegravamen(double seguroDegravamen) {
        this.seguroDegravamen = seguroDegravamen;
    }

    public int getSeguroIncendio() {
        return seguroIncendio;
    }

    public void setSeguroIncendio(int seguroIncendio) {
        this.seguroIncendio = seguroIncendio;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(double financiamiento) {
        this.financiamiento = financiamiento;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public List<Double> getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(List<Double> ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public List<Double> getDeudasMensuales() {
        return deudasMensuales;
    }

    public void setDeudasMensuales(List<Double> deudasMensuales) {
        this.deudasMensuales = deudasMensuales;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
}



