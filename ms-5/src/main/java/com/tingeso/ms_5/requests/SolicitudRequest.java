package com.tingeso.ms_5.requests;


public class SolicitudRequest {

        private Long id;

        private String estado;

        public SolicitudRequest(Long id,String estado) {
            this.id = id;
            this.estado = estado;
        }

        public SolicitudRequest() {
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
