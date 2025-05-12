package com.edutech.plataforma_educativa.micro1usuarios.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "permiso")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToMany(mappedBy = "permisos")
    private List<Rol> roles;

    public Permiso() {}

    public Permiso(String descripcion) {
        this.descripcion = descripcion;
    }


    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

