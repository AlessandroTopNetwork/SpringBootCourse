package com.spring.coredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@EnableWebMvc
@SpringBootApplication
public class CoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoredemoApplication.class, args);
	}

}
