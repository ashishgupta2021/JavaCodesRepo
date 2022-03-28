package com.web.tut07.injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredApp {

	public static void main(String[] args) {

		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut07/injection/applicationContext.xml");
		
		// Constructor Injection
		Coach otherCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(otherCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(otherCoach.getDailyFortune());
		
		// Setter Injection
		Coach theCoach = context.getBean("cricketCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Method Injection
		Coach theAnotherCoach = context.getBean("hockyCoach", Coach.class);
		
		System.out.println(theAnotherCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theAnotherCoach.getDailyFortune());
		
		// Field Injection
		Coach theAnotherCoach2 = context.getBean("footballCoach", Coach.class);
		
		System.out.println(theAnotherCoach2.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theAnotherCoach2.getDailyFortune());
		
		// close the context
		context.close();
	}

}
