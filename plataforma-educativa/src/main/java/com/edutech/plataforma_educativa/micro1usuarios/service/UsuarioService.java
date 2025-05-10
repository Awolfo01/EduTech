package com.edutech.plataforma_educativa.micro1usuarios.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutech.plataforma_educativa.micro1usuarios.model.Usuario;
import com.edutech.plataforma_educativa.micro1usuarios.repository.UsuarioRepository;

// import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    // private final List<Usuario> usuarios = new ArrayList<>(); --ya no se necesita en memoria, ahora está en DB

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
    
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    public Usuario cambiarContrasena(Long id, String nueva) {
        Usuario u = obtenerPorId(id);
        if (u != null) {
            u.cambiarContrasena(nueva);
            return usuarioRepository.save(u);
        }
        return null;
    }
    
    public Usuario activarCuenta(Long id) {
        Usuario u = obtenerPorId(id);
        if (u != null) {
            u.activarCuenta();
            return usuarioRepository.save(u);
        }
        return null;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;
}

