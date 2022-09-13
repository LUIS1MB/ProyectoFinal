package com.proyectofinal.yanki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class YankiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YankiApplication.class, args);
	}

}
