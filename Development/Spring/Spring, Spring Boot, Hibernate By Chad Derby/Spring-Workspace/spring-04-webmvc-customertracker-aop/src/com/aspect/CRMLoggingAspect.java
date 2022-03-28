package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.istack.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// Setup logger
	private Logger logger = Logger.getLogger(CRMLoggingAspect.class);
	
	// Setup pointcut declarations
	@Pointcut("execution(* com.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// Setup pointcut declarations for Service
	@Pointcut("execution(* com.service.*.*(..))")
	private void forServicePackage() {}
	
	// Setup pointcut declarations for DAO
	@Pointcut("execution(* com.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// Add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)	{
		
		// Display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info(">>>> in @Before: calling method: " +  theMethod);
		
		// Display the arguments to the method
		
		// Get the arguemnts
		
		Object[] args = theJoinPoint.getArgs();
		
		// Loop through and display args
		for(Object tempArg : args) {
			logger.info(">>>>> argument: " + tempArg);
		}
	}
	
	// Add @AfterReturning Advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult)	{
		
		// Display method er are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		logger.info(">>>> in @AfterReturning: calling method: " +  theMethod);
		
		// Display data returned
		logger.info(">>>> result: " + theResult);
	}
	
	

}
