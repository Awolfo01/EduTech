package com.edutech.plataforma_educativa.micro3expcliente.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long estudianteId;
    private Long cursoId;
    private LocalDate fechaInscripcion;
    private boolean cancelada; // Mover aquí

    public Inscripcion() {}

    public Inscripcion(Long estudianteId, Long cursoId, LocalDate fechaInscripcion) {
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.fechaInscripcion = fechaInscripcion;
        this.cancelada = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public void cancelarInscripcion() {
        this.cancelada = true;
    }
}
