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
	
	// speficit method of interface
	@Before("execution(public void com.aop.demo.dao.AccountDAO.addAccount())") // not is Before junit // into argusment before execution(singnature of method target)
	public void beforeAddAccountAdvice() { // before is clled only on called method addAccount of Interface AccountDAO
		System.out.println("\n=======> Executing @Before advice on addAccount()");
		System.out.println("i run before method : public void addAccount()\n");
	}
	
	@After("execution(public void addAccount())")
	public void afterAddAccountAdviceWithoutArgs() {
		System.out.println("\n=======> Executing @After advice on addAccount()");
		System.out.println("i run After method : public void addAccount()\n");
	}
	
	@After("execution(public void addAccount(*))")
	public void afterAddAccountAdviceWithOneArgsAny() {
		System.out.println("\n=======> Executing @After advice on addAccount(one args)");
		System.out.println("i run After method : public void addAccount()\n");
	}
	
	@After("execution(public void addAccount(..))")
	public void afterAddAccountAdviceWithMoreArgsAny() {
		System.out.println("\n=======> Executing @After advice on addAccount(more then one args)");
		System.out.println("i run After method : public void addAccount()\n");
	}
	
	// after will be called when method target is terminated, in any case this two methiod will called after or before on any called method target

//	// example that method not call this two method not execute afer or before it
//	@Before("execution(public void updateAccount())") // not is Before junit // into argusment before execution(singnature of method target)
//	public void beforeUpdateAccountAdvice() {
//		System.out.println("\n=======> Executing @Before advice on upadteAccount()");
//		System.out.println("i run before method : public void addAccount()\n");
//	}
//	
//	@After("execution(public void updateAccount())")
//	public void afterUpdateAccountAdvice() {
//		System.out.println("\n=======> Executing @After advice on upadteAccount()");
//		System.out.println("i run After method : public void addAccount()\n");
//	}
	
}
