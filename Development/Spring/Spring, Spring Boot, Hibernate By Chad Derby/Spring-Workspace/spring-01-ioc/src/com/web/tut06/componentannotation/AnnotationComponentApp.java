package com.web.tut06.componentannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationComponentApp {

	public static void main(String[] args) {

		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut06/componentannotation/applicationContext.xml");
		
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("MyCricketCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		Coach otherCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println(otherCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
