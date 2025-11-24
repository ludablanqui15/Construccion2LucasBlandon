package com.castilloInfinito.dto;

public class PilarRequestDTO {

    private String nombre;
    private Integer posX;
    private Integer posY;
    private String estado;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getPosX() { return posX; }
    public void setPosX(Integer posX) { this.posX = posX; }

    public Integer getPosY() { return posY; }
    public void setPosY(Integer posY) { this.posY = posY; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
