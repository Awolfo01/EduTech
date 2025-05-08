package com.edutech.plataforma_educativa.micro1usuarios.controller;


import org.springframework.web.bind.annotation.*;

import com.edutech.plataforma_educativa.micro1usuarios.model.Permiso;
import com.edutech.plataforma_educativa.micro1usuarios.model.Rol;
import com.edutech.plataforma_educativa.micro1usuarios.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/api/micro1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> listar() {
        return rolService.listar();
    }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolService.crear(rol);
    }

    @PutMapping("/{id}/permiso")
    public Rol agregarPermiso(@PathVariable Long id, @RequestBody Permiso permiso) {
        return rolService.asignarPermiso(id, permiso);
    }
}