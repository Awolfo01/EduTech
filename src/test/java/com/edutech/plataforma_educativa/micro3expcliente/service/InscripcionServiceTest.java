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
    void testCancelarInscripcionExistente() {
        Inscripcion inscripcionCancelada = new Inscripcion();
        inscripcionCancelada.setId(1L);
        inscripcionCancelada.cancelarInscripcion();
        
        when(inscripcionRepository.findById(1L)).thenReturn(Optional.of(inscripcion));
        when(inscripcionRepository.save(any(Inscripcion.class))).thenReturn(inscripcionCancelada);
        
        Inscripcion resultado = inscripcionService.cancelar(1L);
        
        assertNotNull(resultado);
    }
}