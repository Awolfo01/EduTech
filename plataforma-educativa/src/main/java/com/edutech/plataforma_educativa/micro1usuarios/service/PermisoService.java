package com.edutech.plataforma_educativa.micro1usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutech.plataforma_educativa.micro1usuarios.model.Permiso;
import com.edutech.plataforma_educativa.micro1usuarios.repository.PermisoRepository;

import java.util.List;

@Service
public class PermisoService {
    @Autowired
    private PermisoRepository permisoRepository;


    public List<Permiso> listar() {
        return permisoRepository.findAll();
    }


    public Permiso crear(Permiso permiso) {
        return permisoRepository.save(permiso);
    }
}
