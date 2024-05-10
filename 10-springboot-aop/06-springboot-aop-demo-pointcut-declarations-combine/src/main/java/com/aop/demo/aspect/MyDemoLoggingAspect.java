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
	@Pointcut("forDaoPackage() && !(getter() || setter())") //  se chiami metodi nel path specificato nel pointcut forDaoPackage ed escludendo i metodi getter andf setter
	private void forDaoPackageNoGetterSetter() {
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method exclude method getter and setter");
	}

//	// create pointcut: include package ... exclude getter/setter
//	@Pointcut("forDaoPackage() && !getter())") //  se chiami metodi nel path specificato nel pointcut forDaoPackage ed escludendo i metodi getter
//	private void forDaoPackageNoGetter() {
//	}
//	
//	// create pointcut: include package ... exclude setter
//	@Pointcut("forDaoPackage() && !setter())") //  se chiami metodi nel path specificato nel pointcut forDaoPackage ed escludendo i metodi setter
//	private void forDaoPackageNoSetter() {
//	}
//
//	@Before("forDaoPackageNoGetter()")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=====>>>GEtter Executing @Before advice on method exclude method getter");
//	}
//
//	@Before("forDaoPackageNoSetter()")
//	public void performApiAnalytics() {
//		System.out.println("\n=====>>>Setter Executing @Before advice on method exclude method setter");
//	}
}
