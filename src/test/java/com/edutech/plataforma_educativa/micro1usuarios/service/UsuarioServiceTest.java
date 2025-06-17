package com.edutech.plataforma_educativa.micro1usuarios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edutech.plataforma_educativa.micro1usuarios.model.Usuario;
import com.edutech.plataforma_educativa.micro1usuarios.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void testGuardarUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setNombre("Felipe");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Act
        Usuario resultado = usuarioService.crear(usuario);

        // Assert
        assertNotNull(resultado);
        assertEquals("Felipe", resultado.getNombre());
        verify(usuarioRepository, times(1)).save(usuario);
    }
}

