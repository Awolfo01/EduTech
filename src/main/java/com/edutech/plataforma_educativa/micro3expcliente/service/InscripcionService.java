package com.edutech.plataforma_educativa.micro3expcliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.edutech.plataforma_educativa.micro3expcliente.model.CursoDTO;
import com.edutech.plataforma_educativa.micro3expcliente.model.Inscripcion;
import com.edutech.plataforma_educativa.micro3expcliente.model.UsuarioDTO;
import com.edutech.plataforma_educativa.micro3expcliente.repository.InscripcionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository, RestTemplate restTemplate) {
        this.inscripcionRepository = inscripcionRepository;
        this.restTemplate = restTemplate;
    }

    public CursoDTO obtenerCurso(Long idCurso) {
        String url = "http://localhost:8081/api/micro2/cursos/" + idCurso;
        return restTemplate.getForObject(url, CursoDTO.class);
    }

    public UsuarioDTO obtenerEstudiante(Long idEstudiante) {
        String url = "http://localhost:8081/api/micro1/usuarios/" + idEstudiante;
        return restTemplate.getForObject(url, UsuarioDTO.class);
    }

    public Inscripcion cancelar(Long id) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);
        if (optionalInscripcion.isPresent()) {
            Inscripcion inscripcion = optionalInscripcion.get();
            inscripcion.cancelarInscripcion();
            return inscripcionRepository.save(inscripcion);
        }
        return null;
    }

    public List<Inscripcion> listar() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion crear(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Optional<Inscripcion> obtenerPorId(Long id) {
        return inscripcionRepository.findById(id);
    }
}