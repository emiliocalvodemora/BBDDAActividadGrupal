package com.unir.laboratorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableCaching
public class BBDDASpringDataApplication {

	/**
	 * Método principal de la aplicación.
	 * @param args - argumentos de la aplicación.
	 */
	public static void main(String[] args) {
		SpringApplication.run(BBDDASpringDataApplication.class, args);
	}

}

