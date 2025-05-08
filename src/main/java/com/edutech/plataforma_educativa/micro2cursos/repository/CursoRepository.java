package com.edutech.plataforma_educativa.micro2cursos.repository;

import com.edutech.plataforma_educativa.micro2cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    //repositorio básico
}
