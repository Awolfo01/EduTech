package com.edutech.plataforma_educativa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PlataformaEducativaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaEducativaApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	//Este bean inyecta RestTemplate para que services como CursoService puedan hacer las llamadas http
}
