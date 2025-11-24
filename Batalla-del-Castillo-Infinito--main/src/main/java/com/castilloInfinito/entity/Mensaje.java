package com.castilloInfinito.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pilarId;

    @Column(length = 2000)
    private String contenidoFragmentado;

    @Column(length = 2000)
    private String contenidoReconstruido;

    private LocalDateTime timestamp;

    @PrePersist
    public void prePersist() {
        if (timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getPilarId() { return pilarId; }

    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }

    public String getContenidoFragmentado() { return contenidoFragmentado; }

    public void setContenidoFragmentado(String contenidoFragmentado) {
        this.contenidoFragmentado = contenidoFragmentado;
    }

    public String getContenidoReconstruido() { return contenidoReconstruido; }

    public void setContenidoReconstruido(String contenidoReconstruido) {
        this.contenidoReconstruido = contenidoReconstruido;
    }

    public LocalDateTime getTimestamp() { return timestamp; }

    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
