package com.edutech.plataforma_educativa.micro2cursos.service;

import com.edutech.plataforma_educativa.micro2cursos.model.Curso;
import com.edutech.plataforma_educativa.micro2cursos.repository.CursoRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;
    //Esta anotación crea una instancia de CursoRepository, de tal manera que no accede a la BD
    //sino a la instancia que funciona en tiempo de ejecución

    @InjectMocks
    private CursoService cursoService;
    //Esta anotación inhyecta cursoRepository en una instancia de cursoService 
    //para acceder al método a probar

    @BeforeEach
    void setUp() {
        // No necesitas código aquí si usas @ExtendWith con Mockito
    }

    @Test
    void testCrearCurso() {
        // Arrange: simulamos la creación de un curso
        Curso curso = new Curso();
        curso.setTitulo("Curso de Spring Boot");
        curso.setDescripcion("Curso introductorio");

        // Simulamos el comportamiento del repositorio
        when(cursoRepository.save(any(Curso.class))).thenReturn(curso);

        // Act: llamamos al método a probar
        Curso resultado = cursoService.crear(curso);

        // Assert: verificamos que el resultado sea el esperado
        assertNotNull(resultado);
        assertEquals("Curso de Spring Boot", resultado.getTitulo());
        assertEquals("Curso introductorio", resultado.getDescripcion());

        // Verificamos que se llamó una vez a save()
        verify(cursoRepository, times(1)).save(curso);
    }
}
