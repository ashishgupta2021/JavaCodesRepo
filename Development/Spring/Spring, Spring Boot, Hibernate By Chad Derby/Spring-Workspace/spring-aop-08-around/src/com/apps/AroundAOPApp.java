package com.apps;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AOPConfig;
import com.service.TrafficFortuneService;

public class AroundAOPApp {

	public static void main(String[] args) {

		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		// Get the bean from spring conatiner
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Main Program: AroundDemoApp");
		
		System.out.println("Calling getFortune()");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("My Fortune is: " + data);
		
		// Close the context
		context.close();
	}

}
