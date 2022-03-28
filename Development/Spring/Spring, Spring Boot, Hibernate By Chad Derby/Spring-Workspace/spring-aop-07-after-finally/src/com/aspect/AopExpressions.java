package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	// Create Pointcut declaration
		@Pointcut("execution(* com.dao.*.*(..))")
		public void forDaoPackage() {
		}

		// Create Pointcut for setter method
		@Pointcut("execution(* com.dao.*.set*(..))")
		public void setter() {
		}

		// Create Pointcut for getter method
		@Pointcut("execution(* com.dao.*.get*(..))")
		public void getter() {
		}

		// Create pointcut that includes packages and exclude getter and setter
		@Pointcut("forDaoPackage() && (!(getter() || setter()))")
		public void forDaoPackageNoGetterSetter() {
		}

}
