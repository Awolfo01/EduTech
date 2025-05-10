package com.edutech.plataforma_educativa.micro2cursos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Leccion> lecciones;

    public Modulo() {}

    public Modulo(String titulo, List<Leccion> lecciones) {
        this.titulo = titulo;
        this.lecciones = lecciones;
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
    
    public List<Leccion> getLecciones() {
        return lecciones;
    }
    
    public void setLecciones(List<Leccion> lecciones) {
        this.lecciones = lecciones;
    }

    public void agregarLeccion(Leccion leccion) {
        this.lecciones.add(leccion);
    }



}

