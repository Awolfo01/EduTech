package com.edutech.plataforma_educativa.micro1usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma_educativa.micro1usuarios.model.Permiso;
import com.edutech.plataforma_educativa.micro1usuarios.model.Rol;
import com.edutech.plataforma_educativa.micro1usuarios.repository.RolRepository;

//import java.util.ArrayList;
import java.util.List;

@Service
public class RolService {
    //private final List<Rol> roles = new ArrayList<>();

    public List<Rol> listar() {
        return rolRepository.findAll();
    }
    
    public Rol crear(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol asignarPermiso(Long rolId, Permiso permiso) {
        Rol rol = obtenerPorId(rolId);
        if (rol != null) {
            rol.asignarPermiso(permiso);
            return rolRepository.save(rol);
        }
        return null;
    }

    @Autowired
    private RolRepository rolRepository;
}
