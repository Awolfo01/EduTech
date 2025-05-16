package com.edutech.plataforma_educativa.micro1usuarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";  // Nombre de la vista (archivo HTML en resources/templates)
    }

        @GetMapping("/aula")
    public String aula(Model model) {
        return "aula";  // Nombre de la vista (archivo HTML en resources/templates)
    }
    
    
}
