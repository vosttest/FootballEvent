package com.tva.fe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tva.fe")
public class FootballEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballEventApplication.class, args);
	}
}
