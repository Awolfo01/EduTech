package com.edutech.plataforma_educativa.micro1usuarios.controller;


import org.springframework.web.bind.annotation.*;
import com.edutech.plataforma_educativa.micro1usuarios.model.Usuario;
import com.edutech.plataforma_educativa.micro1usuarios.service.UsuarioService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/micro1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public Usuario crear(@RequestBody @Valid Usuario usuario) {
        return usuarioService.crear(usuario);
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

@PutMapping("/{id}")
public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
    return usuarioService.actualizarUsuario(id, usuario);
}


}
