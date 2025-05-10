package com.edutech.plataforma_educativa.micro1usuarios.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "rol_permiso",
        joinColumns = @JoinColumn(name = "rol_id"),
        inverseJoinColumns = @JoinColumn(name = "permiso_id")
        )
        private List<Permiso> permisos;

    public Rol() {}

    public Rol(String nombre) {
        this.nombre = nombre;
        this.permisos = new java.util.ArrayList<>();
    }

    public Rol(String nombre, List<Permiso> permisos) {
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Permiso> getPermisos() {
        return permisos;
    }
    
    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public void asignarPermiso(Permiso permiso) {
        this.permisos.add(permiso);
    }

}

