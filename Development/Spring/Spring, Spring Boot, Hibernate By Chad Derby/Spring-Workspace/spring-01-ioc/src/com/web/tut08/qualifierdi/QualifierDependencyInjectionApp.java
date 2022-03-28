package com.web.tut08.qualifierdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifierDependencyInjectionApp {

	public static void main(String[] args) {

		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut08/qualifierdi/applicationContext.xml");
		
		// Constructor Injection
		Coach otherCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(otherCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(otherCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
