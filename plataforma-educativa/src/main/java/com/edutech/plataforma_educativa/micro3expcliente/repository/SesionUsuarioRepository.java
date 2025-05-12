package com.edutech.plataforma_educativa.micro3expcliente.repository;


import com.edutech.plataforma_educativa.micro3expcliente.model.SesionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionUsuarioRepository extends JpaRepository<SesionUsuario, Long> {
}