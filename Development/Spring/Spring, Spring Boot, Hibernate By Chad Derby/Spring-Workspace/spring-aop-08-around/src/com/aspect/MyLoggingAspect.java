package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	
	@Around("execution(* com.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// Print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println(" >>> Exceuting @Around on method: " + method);
		
		// Get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		// get the timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin ;
		
		System.out.println("Duration : " +  duration / 1000.0 + " seconds");
		
		
		
		return result;
	}
}
