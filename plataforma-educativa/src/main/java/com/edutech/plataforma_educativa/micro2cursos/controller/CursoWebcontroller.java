package com.edutech.plataforma_educativa.micro2cursos.controller;

import com.edutech.plataforma_educativa.micro2cursos.model.Curso;
import com.edutech.plataforma_educativa.micro2cursos.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/CursosAdmin")
public class CursoWebcontroller {

    private final CursoService cursoService;

    // CORREGIDO: El constructor debe tener el mismo nombre que la clase
    public CursoWebcontroller(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.listar();
        model.addAttribute("cursos", cursos);
        model.addAttribute("curso", new Curso()); // para el formulario
        return "CursosAdmin"; // Debes tener un CursosAdmin.html
    }

    @PostMapping("/create")
    public String crearCurso(@ModelAttribute Curso curso) {
        cursoService.crear(curso);
        return "redirect:/CursosAdmin";
    }
    

}