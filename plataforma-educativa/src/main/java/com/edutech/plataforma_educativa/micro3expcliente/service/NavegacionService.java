package com.edutech.plataforma_educativa.micro3expcliente.service;

import org.springframework.stereotype.Service;
import com.edutech.plataforma_educativa.micro3expcliente.model.Navegacion;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavegacionService {
    private final List<Navegacion> navegaciones = new ArrayList<>();

    public List<Navegacion> listar() {
        return navegaciones;
    }

    public Navegacion crear(Navegacion navegacion) {
        navegaciones.add(navegacion);
        return navegacion;
    }
}

