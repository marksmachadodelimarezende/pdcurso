package com.prodata.curso.starter;

import core.db.Conexao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;

@SpringBootApplication
public class StarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		//Adicionar dependencia do HttpClient no build.gradle - ref: https://spring.io/guides/gs/rest-service-cors/
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") //Aqui habilita qualquer chamada dentro das origens configuradas abaixo.
						.allowedMethods("GET","POST","PUT","DELETE")
						.allowedHeaders("*")
						.allowedOrigins("*");
			}
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			testConnectDb();
			starterLogApp();
		};
	}

	private void testConnectDb() {
		try {
			Conexao conexao = new Conexao();
			conexao.getCon().close();
		} catch (SQLException e) {
			System.out.println("Erro de conexao ao banco de dados!");
		}
	}

	void starterLogApp() {
		System.out.println("--------------------------------");
		System.out.println("-- PDCURSO - API Inicializada --");
		System.out.println("--------------------------------");
	}
}
