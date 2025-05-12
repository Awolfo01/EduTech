package com.edutech.plataforma_educativa.micro3expcliente.service;

import org.springframework.stereotype.Service;

import com.edutech.plataforma_educativa.micro3expcliente.model.SesionUsuario;
import com.edutech.plataforma_educativa.micro3expcliente.repository.SesionUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SesionUsuarioService {

    @Autowired
    private SesionUsuarioRepository sesionUsuarioRepository;

    public List<SesionUsuario> listar() {
        return sesionUsuarioRepository.findAll();
    }

    public SesionUsuario crear(SesionUsuario sesion) {
        return sesionUsuarioRepository.save(sesion);
    }

    public SesionUsuario obtenerPorId(Long id) {
        return sesionUsuarioRepository.findById(id).orElse(null);
    }

    public boolean estaActiva(Long id) {
        SesionUsuario sesion = obtenerPorId(id);
        return sesion != null && sesion.estaActiva();
    }
}

