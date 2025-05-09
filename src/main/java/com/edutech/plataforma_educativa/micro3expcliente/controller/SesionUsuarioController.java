package com.edutech.plataforma_educativa.micro3expcliente.controller;


import org.springframework.web.bind.annotation.*;

import com.edutech.plataforma_educativa.micro3expcliente.model.SesionUsuario;
import com.edutech.plataforma_educativa.micro3expcliente.service.SesionUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/micro3/sesiones")
public class SesionUsuarioController {
    private final SesionUsuarioService sesionUsuarioService;

    public SesionUsuarioController(SesionUsuarioService sesionUsuarioService) {
        this.sesionUsuarioService = sesionUsuarioService;
    }

    @GetMapping
    public List<SesionUsuario> listar() {
        return sesionUsuarioService.listar();
    }

    @PostMapping
    public SesionUsuario crear(@RequestBody SesionUsuario sesion) {
        return sesionUsuarioService.crear(sesion);
    }
}
