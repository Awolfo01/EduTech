package com.edutech.plataforma_educativa.micro1usuarios.repository;

import com.edutech.plataforma_educativa.micro1usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //repositorio básico
}
