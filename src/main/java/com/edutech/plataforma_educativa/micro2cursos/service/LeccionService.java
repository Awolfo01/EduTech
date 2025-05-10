package com.edutech.plataforma_educativa.micro2cursos.service;

import org.springframework.stereotype.Service;
import com.edutech.plataforma_educativa.micro2cursos.model.Leccion;
import com.edutech.plataforma_educativa.micro2cursos.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LeccionService {

    @Autowired
    private LeccionRepository leccionRepository;

    public List<Leccion> listar() {
        return leccionRepository.findAll();
    }

    public Leccion crear(Leccion leccion) {
        return leccionRepository.save(leccion);
    }

    public Leccion obtenerPorId(Long id) {
        return leccionRepository.findById(id).orElse(null);
    }
}
