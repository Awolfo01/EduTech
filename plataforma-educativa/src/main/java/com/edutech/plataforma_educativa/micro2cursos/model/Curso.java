package com.edutech.plataforma_educativa.micro2cursos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private Long instructorId;

    @Enumerated(EnumType.STRING)
    private EstadoCurso estado;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Modulo> modulos;

    public Curso() {}

    public Curso(String titulo, String descripcion, Long instructorId, EstadoCurso estado, List<Modulo> modulos) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.instructorId = instructorId;
        this.estado = estado;
        this.modulos = modulos;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Long getInstructorId() {
        return instructorId;
    }
    
    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
    
    public EstadoCurso getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoCurso estado) {
        this.estado = estado;
    }
    
    public List<Modulo> getModulos() {
        return modulos;
    }
    
    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public void aprobarCurso() {
        this.estado = EstadoCurso.APROBADO;
    }
    
    public void rechazarCurso() {
        this.estado = EstadoCurso.RECHAZADO;
    }
    
    public void agregarModulo(Modulo modulo) {
        this.modulos.add(modulo);
    }
    

}
