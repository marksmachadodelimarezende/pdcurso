package com.prodata.curso.initializer;

import comum.db.Conexao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class InitializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitializerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			starterLogApp();
			testConnectDb();
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
