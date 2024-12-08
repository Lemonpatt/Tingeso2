package com.tingeso.ms_1.DTO;



public class SimulacionDTO {
    private int valorPropiedad;
    private int plazo;
    private double interes;
    private double financiamiento;

    public SimulacionDTO(int valorPropiedad, int plazo, double interes, double financiamiento) {
        this.valorPropiedad = valorPropiedad;
        this.plazo = plazo;
        this.interes = interes;
        this.financiamiento = financiamiento;
    }

    public int getValorPropiedad() {
        return valorPropiedad;
    }

    public void setValorPropiedad(int valorPropiedad) {
        this.valorPropiedad = valorPropiedad;
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

    public double getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(double financiamiento) {
        this.financiamiento = financiamiento;
    }
}
