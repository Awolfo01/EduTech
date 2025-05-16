package com.edutech.plataforma_educativa.micro1usuarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.edutech.plataforma_educativa.micro1usuarios.model.Usuario;
import com.edutech.plataforma_educativa.micro1usuarios.service.UsuarioService;

import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {

    private final UsuarioService usuarioService;

    public WebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/administrador")
    public String listar(Model model) {
        List<Usuario> usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "administrador"; // Se refiere a lista.html (ubicado en src/main/resources/templates/)
    }

    @GetMapping
    public String home() {
        return ("home");
    }

    @PostMapping
    public String crear(@ModelAttribute Usuario usuario) {// cambiar RequestBody a model atribute para tomar los datos
                                                          // del formulario html
        usuarioService.crear(usuario);
        return ("home");
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @PutMapping("/{id}/contrasena")
    public Usuario cambiarContrasena(@PathVariable Long id, @RequestBody String nueva) {
        return usuarioService.cambiarContrasena(id, nueva);
    }

    @PutMapping("/{id}/activar")
    public Usuario activarCuenta(@PathVariable Long id) {
        return usuarioService.activarCuenta(id);
    }
}
