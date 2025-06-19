package com.edutech.plataforma_educativa.micro3expcliente.service;

import com.edutech.plataforma_educativa.micro3expcliente.model.Inscripcion;
import com.edutech.plataforma_educativa.micro3expcliente.repository.InscripcionRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class InscripcionServiceTest {

    @Mock
    private InscripcionRepository inscripcionRepository;

    @InjectMocks
    private InscripcionService inscripcionService;

    @Test
    void testCrearInscripcion() {
        // Arrange: crear una inscripción simulada
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setFechaInscripcion(LocalDate.of(2024, 6, 1));

        // Simular comportamiento del repositorio
        when(inscripcionRepository.save(any(Inscripcion.class))).thenReturn(inscripcion);

        // Act: llamar al método a probar
        Inscripcion resultado = inscripcionService.crear(inscripcion);

        // Assert: verificar comportamiento
        assertNotNull(resultado);
        assertEquals(LocalDate.of(2024, 6, 1), resultado.getFechaInscripcion());
        verify(inscripcionRepository, times(1)).save(inscripcion);
    }
}
