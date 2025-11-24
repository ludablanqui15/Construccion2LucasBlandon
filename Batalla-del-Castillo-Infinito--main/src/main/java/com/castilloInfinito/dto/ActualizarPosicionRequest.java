package com.castilloInfinito.dto;

public class ActualizarPosicionRequest {

    private Long id;
    private Integer posX;
    private Integer posY;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getPosX() { return posX; }
    public void setPosX(Integer posX) { this.posX = posX; }

    public Integer getPosY() { return posY; }
    public void setPosY(Integer posY) { this.posY = posY; }
}
