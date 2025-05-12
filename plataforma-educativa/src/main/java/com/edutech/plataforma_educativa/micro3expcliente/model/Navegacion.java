package com.edutech.plataforma_educativa.micro3expcliente.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Navegacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private String seccionVisitada;
    private LocalDateTime fechaHora;
    private int duracionSegundos;

    public Navegacion() {}

    public Navegacion(Long usuarioId, String seccionVisitada, LocalDateTime fechaHora, int duracionSegundos) {
        this.usuarioId = usuarioId;
        this.seccionVisitada = seccionVisitada;
        this.fechaHora = fechaHora;
        this.duracionSegundos = duracionSegundos;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public String getSeccionVisitada() {
        return seccionVisitada;
    }
    
    public void setSeccionVisitada(String seccionVisitada) {
        this.seccionVisitada = seccionVisitada;
    }
    
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public int getDuracionSegundos() {
        return duracionSegundos;
    }
    
    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

}
