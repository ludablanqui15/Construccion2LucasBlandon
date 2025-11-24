package com.castilloInfinito.dto;

public class MensajeCrearRequest {

    private Long pilarId;
    private String contenidoFragmentado;

    // Getters y Setters
    public Long getPilarId() { return pilarId; }

    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }

    public String getContenidoFragmentado() { return contenidoFragmentado; }

    public void setContenidoFragmentado(String contenidoFragmentado) {
        this.contenidoFragmentado = contenidoFragmentado;
    }
}
