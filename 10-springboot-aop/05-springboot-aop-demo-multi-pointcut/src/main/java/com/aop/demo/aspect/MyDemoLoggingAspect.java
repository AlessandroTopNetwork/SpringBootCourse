package com.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for loggin

	// let's start an @Before advice

	@Pointcut("execution(* com.aop.demo.dao.*.*(..))") // questo sia ttiva per tutte le classi e i metodi chiamati sotto
														// il package indicato in questo caso com.aop.demo.dao.*.*
														// (class.method)
	private void forDaoPackage() {
	}

	@Before("forDaoPackage()") // se viene chimato il metodo sopra allora si attiverà anche questo di sotto
	public void beforeAddAccountAdvice() {

		System.out.println("\n=====>>> Executing @Before advice on method");

	}

	// craeete a point cut for get methods
	@Pointcut("execution(* com.aop.demo.dao.*.get*(..))")
	private void getter() {

	}

	// creareyet a pointcut for set methods
	@Pointcut("execution(* com.aop.demo.dao.*.set*(..))")
	private void setter() {

	}

	// create pointcut: include package . . . exclude getter/setter methods
	@Pointcut("execution(forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageAndGetterAndSetter() {

	}

}
