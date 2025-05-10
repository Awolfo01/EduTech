package com.edutech.plataforma_educativa.micro3expcliente.controller;

import org.springframework.web.bind.annotation.*;

import com.edutech.plataforma_educativa.micro3expcliente.model.CursoDTO;
import com.edutech.plataforma_educativa.micro3expcliente.model.Inscripcion;
import com.edutech.plataforma_educativa.micro3expcliente.model.UsuarioDTO;
import com.edutech.plataforma_educativa.micro3expcliente.service.InscripcionService;

import java.util.List;

@RestController
@RequestMapping("/api/micro3/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @GetMapping
    public List<Inscripcion> listar() {
        return inscripcionService.listar();
    }

    @PostMapping
    public Inscripcion crear(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.crear(inscripcion);
    }

    @GetMapping("/curso/{id}")
    public CursoDTO obtenerCurso(@PathVariable Long id) {
        return inscripcionService.obtenerCurso(id);
    } // Este endpoint es el que permite la consulta por curso

    @GetMapping("/estudiante/{id}")
    public UsuarioDTO obtenerEstudiante(@PathVariable Long id) {
        return inscripcionService.obtenerEstudiante(id);
    } //Este endpoint permite consultar el estudiante por id

    @PutMapping("/{id}/cancelar")
    public Inscripcion cancelar(@PathVariable Long id) {
        return inscripcionService.cancelar(id);
    }


}

