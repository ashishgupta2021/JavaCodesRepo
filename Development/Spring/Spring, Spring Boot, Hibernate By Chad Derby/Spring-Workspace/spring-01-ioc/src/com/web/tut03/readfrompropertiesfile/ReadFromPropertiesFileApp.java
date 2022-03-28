package com.web.tut03.readfrompropertiesfile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadFromPropertiesFileApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut03/readfrompropertiesfile/applicationContext.xml");
		
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call our new methods to call literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
