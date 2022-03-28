package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

		// Apply Pointcut declaration to advice
		@Before("com.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
		public void logToCloudAsync() {
			System.out.println("\n@Before Logging to Cloud in Async ");
		}
}
