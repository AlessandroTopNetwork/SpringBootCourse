package com.crud.demo.thymeleaft.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution( *  com.crud.demo.thymeleaft.controller.*.*(..))") // any class into path any method and any argusments
    private void forContorllerPackage() {}
    
    // do smae for service and dao
    @Pointcut("execution( *  com.crud.demo.thymeleaft.service.*.*(..))") // any class into path any method and any argusments
    private void forServicePackage() {}
    
    @Pointcut("execution( *  com.crud.demo.thymeleaft.jpa.*.*(..))") // any class into path any method and any argusments
    private void forJpaPackage() {}
    
    @Pointcut("forContorllerPackage() || forServicePackage() || forJpaPackage()")
    private void forAppFlow() {}
    
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
    	
    	// display method we are calling
    	
    	String nameMethod = joinPoint.getSignature().toShortString();
    
    	myLogger.info("method called is : " + nameMethod);
    	
    	// display the arguments
    	
    	Object[] args = joinPoint.getArgs();
    	
    	if(null != args && 0 != args.length) {
	    	
	    	myLogger.info("arguments : ");
	    	
	    	for(Object a : args) {
	    		myLogger.info("	0 : " + a);
	    	}
    	} else {
    		myLogger.info("method not have arguments");
    	}
    	
    	
    }
    
    @AfterReturning(
    		pointcut = "forAppFlow()", // call pointcut
    		returning = "result") // name of returning obj method , uou can call it whatever you want
    public void afterReturning(JoinPoint joinPoint, Object result) {
    	
    	// display method we are calling
    	
    	String nameMethod = joinPoint.getSignature().toShortString();
    
    	myLogger.info("we are into after returning method called is : " + nameMethod);
    	
    	// display data returning
    	myLogger.info("result : " + result);
    	
    }
    
    
    
}











