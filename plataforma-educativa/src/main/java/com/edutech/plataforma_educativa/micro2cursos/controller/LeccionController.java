package com.edutech.plataforma_educativa.micro2cursos.controller;


import org.springframework.web.bind.annotation.*;

import com.edutech.plataforma_educativa.micro2cursos.model.Leccion;
import com.edutech.plataforma_educativa.micro2cursos.service.LeccionService;

import java.util.List;

@RestController
@RequestMapping("/api/micro2/lecciones")
public class LeccionController {
    private final LeccionService leccionService;

    public LeccionController(LeccionService leccionService) {
        this.leccionService = leccionService;
    }

    @GetMapping
    public List<Leccion> listar() {
        return leccionService.listar();
    }

    @PostMapping
    public Leccion crear(@RequestBody Leccion leccion) {
        return leccionService.crear(leccion);
    }
}