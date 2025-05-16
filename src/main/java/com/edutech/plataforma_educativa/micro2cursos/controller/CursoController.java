package com.edutech.plataforma_educativa.micro2cursos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.edutech.plataforma_educativa.micro2cursos.model.Curso;
import com.edutech.plataforma_educativa.micro2cursos.model.Modulo;
import com.edutech.plataforma_educativa.micro2cursos.model.UsuarioDTO;
import com.edutech.plataforma_educativa.micro2cursos.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/micro2/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return cursoService.crear(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

    @GetMapping("/instructor/{id}")
    public UsuarioDTO obtenerInstructor(@PathVariable Long id) {
        return cursoService.obtenerInstructor(id);
    }
    //Este endpoint lo que hace es obtener los datos del instructor (que están en el micro1) desde el micro2

    @GetMapping("/{id}")
    public Curso obtenerPorId(@PathVariable Long id) {
        return cursoService.listar()
        .stream()
        .filter(curso -> curso.getId().equals(id))
        .findFirst()
        .orElse(null);
    } //Este método permite la consulta por ID

    @PutMapping("/{id}/aprobar")
    public Curso aprobar(@PathVariable Long id) {
        return cursoService.aprobarCurso(id);
    }

    @PutMapping("/{id}/rechazar")
    public Curso rechazar(@PathVariable Long id) {
        return cursoService.rechazarCurso(id);
    }

    @PutMapping("/{id}/modulo")
    public Curso agregarModulo(@PathVariable Long id, @RequestBody Modulo modulo) {
        return cursoService.agregarModulo(id, modulo);
    }
}



