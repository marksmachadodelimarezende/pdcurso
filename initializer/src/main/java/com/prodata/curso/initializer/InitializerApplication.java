package com.prodata.curso.initializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InitializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitializerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			starterLogApp();
		};
	}

	void starterLogApp() {
		System.out.println("--------------------------------");
		System.out.println("-- PDCURSO - API Inicializada --");
		System.out.println("--------------------------------");
	}

}
