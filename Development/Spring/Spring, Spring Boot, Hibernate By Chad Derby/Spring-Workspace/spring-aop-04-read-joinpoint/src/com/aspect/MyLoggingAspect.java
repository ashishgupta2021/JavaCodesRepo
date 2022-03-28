package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

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
