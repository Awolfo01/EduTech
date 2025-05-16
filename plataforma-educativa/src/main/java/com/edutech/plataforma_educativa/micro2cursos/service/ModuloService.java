package com.edutech.plataforma_educativa.micro2cursos.service;

import org.springframework.stereotype.Service;
import com.edutech.plataforma_educativa.micro2cursos.model.Leccion;
import com.edutech.plataforma_educativa.micro2cursos.model.Modulo;
import com.edutech.plataforma_educativa.micro2cursos.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo> listar() {
        return moduloRepository.findAll();
    }

    public Modulo crear(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public Modulo obtenerPorId(Long id) {
        return moduloRepository.findById(id).orElse(null);
    }

    public Modulo agregarLeccion(Long moduloId, Leccion leccion) {
        Modulo modulo = obtenerPorId(moduloId);
        if (modulo != null) {
            modulo.agregarLeccion(leccion);
            return moduloRepository.save(modulo);
        }
        return null;
    }
}
