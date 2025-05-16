package com.edutech.plataforma_educativa.micro2cursos.controller;

import org.springframework.web.bind.annotation.*;

import com.edutech.plataforma_educativa.micro2cursos.model.Leccion;
import com.edutech.plataforma_educativa.micro2cursos.model.Modulo;
import com.edutech.plataforma_educativa.micro2cursos.service.ModuloService;

import java.util.List;

@RestController
@RequestMapping("/api/micro2/modulos")
public class ModuloController {
    private final ModuloService moduloService;

    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }

    @GetMapping
    public List<Modulo> listar() {
        return moduloService.listar();
    }

    @PostMapping
    public Modulo crear(@RequestBody Modulo modulo) {
        return moduloService.crear(modulo);
    }

    @PutMapping("/{id}/leccion")
    public Modulo agregarLeccion(@PathVariable Long id, @RequestBody Leccion leccion) {
        return moduloService.agregarLeccion(id, leccion);
    }
}