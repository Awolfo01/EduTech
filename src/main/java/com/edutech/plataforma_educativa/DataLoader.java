package com.edutech.plataforma_educativa;

import com.edutech.plataforma_educativa.micro1usuarios.model.Permiso;
import com.edutech.plataforma_educativa.micro1usuarios.model.Rol;
import com.edutech.plataforma_educativa.micro1usuarios.model.Usuario;
import com.edutech.plataforma_educativa.micro1usuarios.repository.PermisoRepository;
import com.edutech.plataforma_educativa.micro1usuarios.repository.RolRepository;
import com.edutech.plataforma_educativa.micro1usuarios.repository.UsuarioRepository;
import com.edutech.plataforma_educativa.micro2cursos.model.Curso;
import com.edutech.plataforma_educativa.micro2cursos.model.EstadoCurso;
import com.edutech.plataforma_educativa.micro2cursos.model.Leccion;
import com.edutech.plataforma_educativa.micro2cursos.model.Modulo;
import com.edutech.plataforma_educativa.micro2cursos.repository.CursoRepository;
import com.edutech.plataforma_educativa.micro2cursos.repository.LeccionRepository;
import com.edutech.plataforma_educativa.micro2cursos.repository.ModuloRepository;
import com.edutech.plataforma_educativa.micro3expcliente.model.Inscripcion;
import com.edutech.plataforma_educativa.micro3expcliente.model.Navegacion;
import com.edutech.plataforma_educativa.micro3expcliente.model.SesionUsuario;
import com.edutech.plataforma_educativa.micro3expcliente.repository.InscripcionRepository;
import com.edutech.plataforma_educativa.micro3expcliente.repository.NavegacionRepository;
import com.edutech.plataforma_educativa.micro3expcliente.repository.SesionUsuarioRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DataLoader {

    @Autowired
    private PermisoRepository permisoRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private LeccionRepository leccionRepository;
    @Autowired
    private ModuloRepository moduloRepository;
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private NavegacionRepository navegacionRepository;
    @Autowired
    private SesionUsuarioRepository sesionUsuarioRepository;

    private final Faker faker = new Faker();

    @PostConstruct
    public void init() {
        // Micro 1 - Permiso, Rol, Usuario
        List<Permiso> permisos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Permiso permiso = new Permiso();
            permiso.setDescripcion("Permiso para " + faker.job().keySkills());
            permisos.add(permiso);
        }
        permisoRepository.saveAll(permisos);

        List<Rol> roles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Rol rol = new Rol();
            rol.setNombre("ROL_" + faker.job().position());
            rol.setPermisos(permisos);
            roles.add(rol);
        }
        rolRepository.saveAll(roles);

        List<Usuario> usuarios = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Usuario usuario = new Usuario();
            usuario.setNombre(faker.name().fullName());
            usuario.setEmail(faker.internet().emailAddress());
            usuario.setContrasena(faker.internet().password());
            usuario.setActivo(true);
            usuario.setRol(roles.get(i % roles.size()));
            usuarios.add(usuario);
        }
        usuarioRepository.saveAll(usuarios);

        // Micro 2 - Curso, Modulo, Leccion
        List<Curso> cursos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Curso curso = new Curso();
            curso.setTitulo("Curso de " + faker.educator().course());
            curso.setDescripcion(faker.lorem().paragraph());
            curso.setInstructorId(usuarios.get(i % usuarios.size()).getId());
            curso.setEstado(EstadoCurso.APROBADO);
            cursos.add(curso);
        }
        cursoRepository.saveAll(cursos);

        List<Modulo> modulos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Modulo modulo = new Modulo();
            modulo.setTitulo("Modulo " + (i + 1));
            modulos.add(modulo);
        }
        moduloRepository.saveAll(modulos);

        List<Leccion> lecciones = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Leccion leccion = new Leccion();
            leccion.setTitulo(faker.educator().course());
            leccion.setContenido(faker.lorem().paragraph());
            lecciones.add(leccion);
        }
        leccionRepository.saveAll(lecciones);

        // Micro 3 - Inscripcion, Navegacion, SesionUsuario
        List<Inscripcion> inscripciones = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setEstudianteId(usuarios.get(i % usuarios.size()).getId());
            inscripcion.setCursoId(cursos.get(i % cursos.size()).getId());
            inscripcion.setFechaInscripcion(LocalDate.now().minusDays(faker.number().numberBetween(1, 100)));            inscripcion.setCancelada(false);
            inscripciones.add(inscripcion);
        }
        inscripcionRepository.saveAll(inscripciones);

        List<Navegacion> navegaciones = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Navegacion nav = new Navegacion();
            nav.setUsuarioId(usuarios.get(i % usuarios.size()).getId());
            nav.setSeccionVisitada("/seccion/" + faker.lorem().word());
            nav.setFechaHora(LocalDateTime.now().minusMinutes(faker.number().numberBetween(1, 1000)));
            nav.setDuracionSegundos(faker.number().numberBetween(10, 500));
            navegaciones.add(nav);
        }
        navegacionRepository.saveAll(navegaciones);

        List<SesionUsuario> sesiones = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SesionUsuario sesion = new SesionUsuario();
            sesion.setUsuarioId(usuarios.get(i % usuarios.size()).getId());
            sesion.setToken(UUID.randomUUID().toString());
            sesion.setFechaInicio(LocalDateTime.now().minusHours(faker.number().numberBetween(1, 12)));
            sesion.setFechaExpiracion(LocalDateTime.now().plusHours(1));
            sesiones.add(sesion);
        }
        sesionUsuarioRepository.saveAll(sesiones);
    }
}
