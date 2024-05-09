package com.aop.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for loggin
	
	// let's start an @Before advice
	
	@Before("execution(public void addAccount())") // not is Before junit // into argusment before execution(singnature of method target)
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======> Executing @Before advice on addAccount()");
		System.out.println("i run before method : public void addAccount()\n");
	}
	
	@After("execution(public void addAccount())")
	public void afterAddAccountAdvice() {
		System.out.println("\n=======> Executing @After advice on addAccount()");
		System.out.println("i run After method : public void addAccount()\n");
	}
	
	// after will be called when method target is terminated, in any case this two methiod will called after or before on any called method target

}
