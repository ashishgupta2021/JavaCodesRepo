package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	// This is where we add all of our related advices for logging
	
	// Let's start with an @Before advice
	
	/* Match for only com.dao.AccountDAO.addAccount() Method   */
	@Before("execution(public void com.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n Executing @Before advice on addAccount() ");
	}
}
