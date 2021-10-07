package com.sofka.StepVerifier;

import com.sofka.StepVerifier.Services.Servicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StepVerifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(StepVerifierApplication.class, args);
		Servicio servucio = new Servicio();
		servucio.buscarTodosFiltro();
	}
}