package com.edutech.plataforma_educativa.micro2cursos.repository;


import com.edutech.plataforma_educativa.micro2cursos.model.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeccionRepository extends JpaRepository<Leccion, Long> {
}
