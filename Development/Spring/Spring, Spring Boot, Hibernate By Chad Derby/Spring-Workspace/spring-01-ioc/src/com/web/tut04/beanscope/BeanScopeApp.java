package com.web.tut04.beanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut04/beanscope/beanScope-applicationContext.xml");
		
		
		// retrieve bean from spring container using singleton
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		CricketCoach alphaCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// check if they are the same bean
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nSingleton Demo\n");
		System.out.println("Pointing to the same object " + result);
		
		System.out.println("Memory location for theCoach: " + theCoach);
		
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		// retrieve bean from spring container using prototype

		
		CricketCoach theCoachOne = context.getBean("myCricketCoachByPrototype", CricketCoach.class);
		
		CricketCoach alphaCoachOne = context.getBean("myCricketCoachByPrototype", CricketCoach.class);

		// check if they are the same bean
		result = (theCoachOne == alphaCoachOne);
		
		// print out the results
		System.out.println("\nPrototypeDemo\n");

		System.out.println("Pointing to the same object " + result);
		
		System.out.println("Memory location for theCoachOne: " + theCoachOne);
		
		System.out.println("Memory location for alphaCoachOne: " + alphaCoachOne);
		

		
		
		// close the context
		context.close();
	}

}
