package com.apps;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AOPConfig;
import com.service.TrafficFortuneService;

public class AroundHandleExceptionAOPApp {
	
	private static Logger logger = Logger.getLogger(AroundHandleExceptionAOPApp.class.getName());

	public static void main(String[] args) {

		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		// Get the bean from spring conatiner
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("Main Program: AroundDemoApp");
		
		logger.info("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = theFortuneService.getFortune(tripWire);
		
		logger.info("My Fortune is: " + data);
		
		// Close the context
		context.close();
	}

}
