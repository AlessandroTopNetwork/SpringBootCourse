package com.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.aop.demo.dao.*.*(..))")
	private void forDaoPackage() {
		System.out.println("pointcut package");
	}

	// create a pointcut for getter methods
	@Pointcut("execution(* com.aop.demo.dao.*.get*(..))") // se chiami metodi getter
	private void getter() {
	}

	// create a pointcut for setter methods
	@Pointcut("execution(* com.aop.demo.dao.*.set*(..))") // se chiami metodi setter
	private void setter() {
	}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())") //  se chiami metodi nele path specificato nel pointcut forDaoPackage e 
	private void forDaoPackageNoGetterSetter() {
		System.out.println("poit cut execute ");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}
}
