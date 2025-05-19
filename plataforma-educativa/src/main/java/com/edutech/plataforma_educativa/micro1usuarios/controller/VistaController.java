package com.edutech.plataforma_educativa.micro1usuarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edutech.plataforma_educativa.micro2cursos.model.Curso;

@Controller
public class VistaController {

    // @GetMapping("/")
    // public String home(Model model) {
    //     return "home";  // Nombre de la vista (archivo HTML en resources/templates)
    // }

        @GetMapping("/aula")
    public String aula(Model model) {
        return "aula";  // Nombre de la vista (archivo HTML en resources/templates)
    }
    @GetMapping("/Administrador")
    public String Administrador(Model model) {
        return "Administrador";  // Nombre de la vista (archivo HTML en resources/templates)
    }
    @GetMapping("/recuperarCuenta")
    public String recuperarCuenta(Model model) {
        return "recuperarCuenta";  // Nombre de la vista (archivo HTML en resources/templates)
    }
    @GetMapping("/IniciarSesion")
    public String IniciarSesion(Model model) {
        return "IniciarSesion";  // Nombre de la vista (archivo HTML en resources/templates)
    }
    //    @GetMapping("/CursosAdmin")
    //public String CursosAdmin(Model model) {
    //    return "CursosAdmin";  // Nombre de la vista (archivo HTML en resources/templates)
    //}
  
}
