package com.castilloInfinito.dto;

public class TriangulacionResponseDTO {

    private Coordenada posiblePosicionMuzan;
    private Double nivelConfianza;
    private String descripcion;

    public static class Coordenada {
        private Integer x;
        private Integer y;

        public Coordenada() {}

        public Coordenada(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() { return x; }
        public void setX(Integer x) { this.x = x; }

        public Integer getY() { return y; }
        public void setY(Integer y) { this.y = y; }
    }

    public TriangulacionResponseDTO() {}

    public Coordenada getPosiblePosicionMuzan() {
        return posiblePosicionMuzan;
    }

    public void setPosiblePosicionMuzan(Coordenada posiblePosicionMuzan) {
        this.posiblePosicionMuzan = posiblePosicionMuzan;
    }

    public Double getNivelConfianza() {
        return nivelConfianza;
    }

    public void setNivelConfianza(Double nivelConfianza) {
        this.nivelConfianza = nivelConfianza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
