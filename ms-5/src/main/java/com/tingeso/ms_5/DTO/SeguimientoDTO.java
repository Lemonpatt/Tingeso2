package com.tingeso.ms_5.DTO;

import java.util.List;

public class SeguimientoDTO {

        private Long id;

        public SeguimientoDTO(Long id, String correo, String telefono, int valorPropiedad, List<String> nombreArchivos, List<String> documentos, String tipoPrestamo, int antiguedadTrabajo, String tipoTrabajo, int plazo, double interes, double seguroDegravamen, int seguroIncendio, double comision, double financiamiento, double cuotaMensual, List<Double> ingresosMensuales, List<Double> deudasMensuales, String estado, long usuario) {
            this.id = id;
            this.correo = correo;
            this.telefono = telefono;
            this.valorPropiedad = valorPropiedad;
            this.nombreArchivos = nombreArchivos;
            this.documentos = documentos;
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
            this.estado = estado;
            this.usuario = usuario;
        }

        public SeguimientoDTO() {
        }
// Relación con Usuario (muchas solicitudes pueden pertenecer a un usuario)

        private String correo;

        private String telefono;

        private int valorPropiedad;

        private List<String> nombreArchivos;


        private List<String> documentos;

        private String tipoPrestamo;

        private int antiguedadTrabajo; // Años de antigüedad en el trabajo

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

        private String estado;
        private long usuario;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public int getValorPropiedad() {
            return valorPropiedad;
        }

        public void setValorPropiedad(int valorPropiedad) {
            this.valorPropiedad = valorPropiedad;
        }

        public List<String> getNombreArchivos() {
            return nombreArchivos;
        }

        public void setNombreArchivos(List<String> nombreArchivos) {
            this.nombreArchivos = nombreArchivos;
        }

        public List<String> getDocumentos() {
            return documentos;
        }

        public void setDocumentos(List<String> documentos) {
            this.documentos = documentos;
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

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public long getUsuario() {
            return usuario;
        }

        public void setUsuario(long usuario) {
            this.usuario = usuario;
        }
}
