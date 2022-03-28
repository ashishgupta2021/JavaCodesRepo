package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	// This is where we add all of our related advices for logging
	
	// Let's start with an @Before advice
	
	// Create Pointcut declaration
	@Pointcut("execution(* com.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	// Apply Pointcut declaration to advice
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n Executing @Before advice on addAccount() ");
	}
	
	// Apply Pointcut declaration to advice
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n@Before Perform API Analytics ");
	}
}
