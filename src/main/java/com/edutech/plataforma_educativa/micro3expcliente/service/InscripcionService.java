package com.edutech.plataforma_educativa.micro3expcliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.edutech.plataforma_educativa.micro3expcliente.model.CursoDTO;
import com.edutech.plataforma_educativa.micro3expcliente.model.Inscripcion;
import com.edutech.plataforma_educativa.micro3expcliente.model.UsuarioDTO;
import com.edutech.plataforma_educativa.micro3expcliente.repository.InscripcionRepository;

//import java.util.ArrayList;
import java.util.List;

@Service
public class InscripcionService {

    //private final List<Inscripcion> inscripciones = new ArrayList<>();
    private final RestTemplate restTemplate;

    public InscripcionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CursoDTO obtenerCurso(Long idCurso) {
        String url = "http://localhost:8081/api/micro2/cursos/" + idCurso;
        return restTemplate.getForObject(url, CursoDTO.class);
    }

    public UsuarioDTO obtenerEstudiante(Long idEstudiante) {
        String url = "http://localhost:8081/api/micro1/usuarios/" + idEstudiante;
        return restTemplate.getForObject(url, UsuarioDTO.class);
    } //Este metodo per,ite obtener el estudiante (que es un dato de la clase Usuario, del paquete de micro1)

    public Inscripcion cancelar(Long id) {
        Inscripcion ins = obtenerPorId(id);
        if (ins != null) {
            ins.cancelarInscripcion();
            return inscripcionRepository.save(ins);
        }
        return null;
    }
    
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> listar() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion crear(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Inscripcion obtenerPorId(Long id) {
       return inscripcionRepository.findById(id).orElse(null);
    }

}