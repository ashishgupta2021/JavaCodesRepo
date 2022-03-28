package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

		// Apply Pointcut declaration to advice
		@Before("com.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
		public void performApiAnalytics() {
			System.out.println("\n@Before Perform API Analytics ");
		}
}
