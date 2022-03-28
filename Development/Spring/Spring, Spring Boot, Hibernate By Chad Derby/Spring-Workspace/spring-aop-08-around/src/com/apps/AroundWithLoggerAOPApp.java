package com.apps;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AOPConfig;
import com.service.TrafficFortuneService;

public class AroundWithLoggerAOPApp {
	
	private static Logger logger = Logger.getLogger(AroundWithLoggerAOPApp.class.getName());

	public static void main(String[] args) {

		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		// Get the bean from spring conatiner
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("Main Program: AroundDemoApp");
		
		logger.info("Calling getFortune()");
		
		String data = theFortuneService.getFortune();
		
		logger.info("My Fortune is: " + data);
		
		// Close the context
		context.close();
	}

}
