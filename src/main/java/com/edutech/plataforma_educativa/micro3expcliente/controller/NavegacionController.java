package com.edutech.plataforma_educativa.micro3expcliente.controller;

import org.springframework.web.bind.annotation.*;
import com.edutech.plataforma_educativa.micro3expcliente.model.Navegacion;
import com.edutech.plataforma_educativa.micro3expcliente.service.NavegacionService;

import java.util.List;

@RestController
@RequestMapping("/api/micro3/navegacion")
public class NavegacionController {
    private final NavegacionService navegacionService;

    public NavegacionController(NavegacionService navegacionService) {
        this.navegacionService = navegacionService;
    }

    @GetMapping
    public List<Navegacion> listar() {
        return navegacionService.listar();
    }

    @PostMapping
    public Navegacion crear(@RequestBody Navegacion navegacion) {
        return navegacionService.crear(navegacion);
    }
}
