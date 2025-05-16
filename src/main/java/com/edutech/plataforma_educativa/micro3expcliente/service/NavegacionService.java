package com.edutech.plataforma_educativa.micro3expcliente.service;

import org.springframework.stereotype.Service;
import com.edutech.plataforma_educativa.micro3expcliente.model.Navegacion;
import com.edutech.plataforma_educativa.micro3expcliente.repository.NavegacionRepository;

import java.util.List;

@Service
public class NavegacionService {
    private final NavegacionRepository navegacionRepository;

    public NavegacionService(NavegacionRepository navegacionRepository) {
        this.navegacionRepository = navegacionRepository;
    }

    public List<Navegacion> listar() {
        return navegacionRepository.findAll();
    }

    public Navegacion crear(Navegacion navegacion) {
        return navegacionRepository.save(navegacion);
    }
}

