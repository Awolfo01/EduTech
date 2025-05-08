package com.edutech.plataforma_educativa.micro1usuarios.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    public Usuario() {}

    public Usuario(String nombre, String email, String contrasena, boolean activo) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.activo = activo;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void cambiarContrasena(String nueva) {
        this.contrasena = nueva;
    }
    
    public void activarCuenta() {
        this.activo = true;
    }
    
    public void desactivarCuenta() {
        this.activo = false;
    }

    //Estos métodos quedan aquí, espero no estar equivocado, para modificar el estado interno del objeto mientras el programa está en ejecución

}

