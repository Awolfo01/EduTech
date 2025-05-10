package com.edutech.plataforma_educativa.micro1usuarios.controller;

import org.springframework.web.bind.annotation.*;
import com.edutech.plataforma_educativa.micro1usuarios.model.Permiso;
import com.edutech.plataforma_educativa.micro1usuarios.service.PermisoService;

import java.util.List;

@RestController
@RequestMapping("/api/micro1/permisos")
public class PermisoController {
    private final PermisoService permisoService;

    public PermisoController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @GetMapping
    public List<Permiso> listar() {
        return permisoService.listar();
    }

    @PostMapping
    public Permiso crear(@RequestBody Permiso permiso) {
        return permisoService.crear(permiso);
    }
}
