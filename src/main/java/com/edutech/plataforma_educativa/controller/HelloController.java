package com.edutech.plataforma_educativa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "¡Aplicación desplegada y funcionando correctamente en Railway!";
    }
}
