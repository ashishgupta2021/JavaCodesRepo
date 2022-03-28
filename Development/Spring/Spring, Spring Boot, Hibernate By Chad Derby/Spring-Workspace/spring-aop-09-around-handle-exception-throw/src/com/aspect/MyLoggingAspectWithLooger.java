package com.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyLoggingAspectWithLooger {
	
	Logger logger = Logger.getLogger(MyLoggingAspectWithLooger.class.getName());
	
	@Around("execution(* com.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// Print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		logger.info(" >>> Exceuting @Around on method: " + method);
		
		// Get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			logger.warning(e.getMessage());
			
			// Give user a custom message
			result = "Major accident! But no worries"; 
			throw e;
		}
		
		
		// get the timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin ;
		
		logger.info("Duration : " +  duration / 1000.0 + " seconds");
		
		
		
		return result;
	}
}
