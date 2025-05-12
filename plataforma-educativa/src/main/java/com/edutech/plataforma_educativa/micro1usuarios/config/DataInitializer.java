package com.edutech.plataforma_educativa.micro1usuarios.config;

import com.edutech.plataforma_educativa.micro1usuarios.model.Rol;
import com.edutech.plataforma_educativa.micro1usuarios.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RolRepository rolRepository) {
        return args -> {
            if (rolRepository.count() == 0) {
                rolRepository.save(new Rol("ESTUDIANTE"));
                rolRepository.save(new Rol("INSTRUCTOR"));
                rolRepository.save(new Rol("ADMIN"));
                System.out.println("Roles iniciales creados.");
            } else {
                System.out.println("Los roles ya existen. No se crearon duplicados.");
            }
        };
    }
}
