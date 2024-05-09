package com.aop.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aop.demo.dao.AccountDAO;
import com.aop.demo.dao.MembershipDAO;
import com.aop.demo.dto.AccountDto;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean // when you have method annotation with bean it will be exceute on start application and injection autowired the dipendece obj arguments have it
	public CommandLineRunner lineRunner(AccountDAO accoutnDao, MembershipDAO membershipDao) {
		return runner ->{
			addAccount(accoutnDao, membershipDao);
		};
	}
	
	private void addAccount(AccountDAO accountDao, MembershipDAO membershipDao) {
		
		System.err.println("\n call account method \n");
		
		accountDao.addAccount();
		
		// call athor method into athor class
		
		System.err.println("\n call merbership method \n");
		
		membershipDao.addAccount();
		
		membershipDao.addAccount(null);
		
		membershipDao.addAccount(null, null);
		
		accountDao.addAccount(new AccountDto());
	}

}
