package com.spring.coredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { // if use it we need to write every package use else package will be ignored
		"com.spring.util",
		"com.spring.coredemo"
}) // this will use when we have a package extarnal e not sub at package root of app of is this class SpringApplication.run
public class CoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoredemoApplication.class, args);
	}

}
