package com.castilloInfinito.dto;

public class ErrorResponse {

    private String tipo;
    private String mensaje;

    public ErrorResponse(String tipo, String mensaje) {
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
