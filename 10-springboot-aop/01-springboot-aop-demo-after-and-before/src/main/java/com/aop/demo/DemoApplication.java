package com.aop.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aop.demo.dao.AccountDAO;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean // when you have method annotation with bean it will be exceute on start application and injection autowired the dipendece obj arguments have it
	public CommandLineRunner lineRunner(AccountDAO accoutnDao) {
		return runner ->{
			addAccount(accoutnDao);
		};
	}
	
	private void addAccount(AccountDAO accountDao) {
		accountDao.addAccount();
		
		System.err.println("\npause\n");
		
		accountDao.addAccount();
	}

}
