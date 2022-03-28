package com.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.entity.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	
	
	@AfterThrowing(pointcut = "execution(* com.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// Print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println(" >>> @AfterThrwoing " + method);
		
		// Log the exception
		System.out.println(">>> The Exception is:" + theExc);
	}

	// Add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(pointcut = "execution(* com.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println(" >>> " + method);
		
		// Print out the results of the method call
		System.out.println(" >>> result is " + result);
		
		// Let's post-process the data ... let's modify it
		
		// Convert the Account name to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("After post process result is ");
		System.out.println(result);

		
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// Loop through accounts
		
		for(Account tempAccount: result) {
			
			// Get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
		
			// update the name on the account
			tempAccount.setName(theUpperName);
		}	 
	}

	// Apply Pointcut declaration to advice
	
	@Before("com.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n Executing @Before advice on addAccount() ");
		
		// Display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		
		// Display method arguments
		
		// Get args
		Object[] args = theJoinPoint.getArgs();
		System.out.println("Arguments ");
		// Loop through args
		for(Object tempArg : args)	{
			System.out.println(tempArg);
		}
	}

}
