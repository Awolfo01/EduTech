package com.edutech.plataforma_educativa.micro3expcliente.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SesionUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Generado para pruyeba

    private String token;

    private Long usuarioId;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaExpiracion;

    public SesionUsuario() {}

    public SesionUsuario(String token, Long usuarioId, LocalDateTime fechaInicio, LocalDateTime fechaExpiracion) {
        this.token = token;
        this.usuarioId = usuarioId;
        this.fechaInicio = fechaInicio;
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean estaActiva() {
        return fechaExpiracion.isAfter(LocalDateTime.now());
    }


    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public Long getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }
    
    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }


}

