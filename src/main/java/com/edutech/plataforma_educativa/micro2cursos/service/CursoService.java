package com.edutech.plataforma_educativa.micro2cursos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.edutech.plataforma_educativa.micro2cursos.model.Curso;
import com.edutech.plataforma_educativa.micro2cursos.model.Modulo;
import com.edutech.plataforma_educativa.micro2cursos.model.UsuarioDTO;
import com.edutech.plataforma_educativa.micro2cursos.repository.CursoRepository;

//import java.util.ArrayList;
import java.util.List;

//Aquí agregué la dependencia a restTemplte y un método para obtener el instructor (consumir la api microservicio 1 en el microservico 2, este)

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final RestTemplate restTemplate;

    public CursoService(CursoRepository cursoRepository, RestTemplate restTemplate) {
        this.cursoRepository = cursoRepository;
        this.restTemplate = restTemplate;
    }

    public UsuarioDTO obtenerInstructor(Long idInstructor) {
        String url = "http://localhost:8081/api/micro1/usuarios/" + idInstructor;
        return restTemplate.getForObject(url, UsuarioDTO.class);
    }

    public Curso aprobarCurso(Long id) {
        Curso curso = obtenerPorId(id);
        if (curso != null) {
            curso.aprobarCurso();
            return cursoRepository.save(curso);
        }
        return null;
    }

    public Curso rechazarCurso(Long id) {
        Curso curso = obtenerPorId(id);
        if (curso != null) {
            curso.rechazarCurso();
            return cursoRepository.save(curso);
        }
        return null;
    }

    public Curso agregarModulo(Long cursoId, Modulo modulo) {
        Curso curso = obtenerPorId(cursoId);
        if (curso != null) {
            curso.agregarModulo(modulo);
            return cursoRepository.save(curso);
        }
        return null;
    }

    public void eliminarCurso(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Curso no encontrado con ID: " + id);
        }
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso crear(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

}
