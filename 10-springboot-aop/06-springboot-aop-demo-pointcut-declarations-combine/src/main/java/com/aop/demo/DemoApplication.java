package com.aop.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aop.demo.dao.AccountDAO;
import com.aop.demo.dao.MembershipDAO;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean // when you have method annotation with bean it will be exceute on start application and injection autowired the dipendece obj arguments have it
	public CommandLineRunner lineRunner(AccountDAO accoutnDao, MembershipDAO membershipDao) {
		return runner ->{
			demoTheBeforeAdvice(accoutnDao, membershipDao);
		};
	}
	
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
//		theAccountDAO.setName("foobar");
//		theAccountDAO.setServiceCode("silver");
//
//		String name = theAccountDAO.getName();
//		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}
