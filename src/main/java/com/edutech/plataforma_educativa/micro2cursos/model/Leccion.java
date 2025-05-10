package com.edutech.plataforma_educativa.micro2cursos.model;

import jakarta.persistence.*;

@Entity
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String contenido;

    public Leccion() {}

    public Leccion(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
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
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}

