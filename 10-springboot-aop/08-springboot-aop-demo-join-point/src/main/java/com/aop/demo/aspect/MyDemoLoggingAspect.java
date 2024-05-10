package com.aop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect { // second methid call @Before target method

    @Before("com.aop.demo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }
    
    // display the method signature
    @Before("com.aop.demo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void getSignatureMethod(JoinPoint joinPoint) { // work
    	
    	MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    	
    	System.out.println( "method signature : " + methodSignature);
    }
    
    // display method arguments
    @Before("com.aop.demo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void getArgumentsOfMethod(JoinPoint joinPoint) { // work
    	
    	Object[] args =  joinPoint.getArgs();
    	
    	System.out.println( "method arguments : " );
    	
    	for(Object obj : args) {
    		if(obj instanceof Account) {
    			
    			// Downcast and print Account specific stuff
    			Account a = (Account) obj;
    			
    			System.out.println("account name : " + a.getName());
    			System.out.println("account level : " + a.getLevel());
    			
    		}
    		System.out.println(obj); // in case is obj like Account prima path of memory if not overire toString method
    	}
    	
    }
}











