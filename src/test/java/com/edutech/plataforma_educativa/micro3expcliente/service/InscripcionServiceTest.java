package com.edutech.plataforma_educativa.micro3expcliente.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.edutech.plataforma_educativa.micro3expcliente.model.Inscripcion;
import com.edutech.plataforma_educativa.micro3expcliente.repository.InscripcionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class InscripcionServiceTest {

    @Mock
    private InscripcionRepository inscripcionRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private InscripcionService inscripcionService;

    private Inscripcion inscripcion;

    @BeforeEach
    void setUp() {
        inscripcion = new Inscripcion();
        inscripcion.setId(1L);
        // Configura otros campos necesarios
    }

    @Test
    void testCrearInscripcion() {
        when(inscripcionRepository.save(any(Inscripcion.class))).thenReturn(inscripcion);
        
        Inscripcion resultado = inscripcionService.crear(inscripcion);
        
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(inscripcionRepository, times(1)).save(inscripcion);
    }

    @Test
    void testObtenerPorIdExistente() {
        when(inscripcionRepository.findById(1L)).thenReturn(Optional.of(inscripcion));
        
        Optional<Inscripcion> resultado = inscripcionService.obtenerPorId(1L);
        
        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
    }

    @Test
    void testObtenerPorIdNoExistente() {
        when(inscripcionRepository.findById(2L)).thenReturn(Optional.empty());
        
        Optional<Inscripcion> resultado = inscripcionService.obtenerPorId(2L);
        
        assertFalse(resultado.isPresent());
    }

    @Test
    void testCancelarInscripcionExistente() {
        Inscripcion inscripcionCancelada = new Inscripcion();
        inscripcionCancelada.setId(1L);
        inscripcionCancelada.cancelarInscripcion();
        
        when(inscripcionRepository.findById(1L)).thenReturn(Optional.of(inscripcion));
        when(inscripcionRepository.save(any(Inscripcion.class))).thenReturn(inscripcionCancelada);
        
        Inscripcion resultado = inscripcionService.cancelar(1L);
        
        assertNotNull(resultado);
        assertTrue(resultado.isCancelada()); // Asumiendo que hay un método isCancelada()
    }

    @Test
    void testListarInscripciones() {
        List<Inscripcion> inscripciones = Arrays.asList(inscripcion);
        when(inscripcionRepository.findAll()).thenReturn(inscripciones);
        
        List<Inscripcion> resultado = inscripcionService.listar();
        
        assertEquals(1, resultado.size());
        verify(inscripcionRepository, times(1)).findAll();
    }
}