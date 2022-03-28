package com.web.tut05.beanlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut05/beanlifecycle/applicationContext.xml");
		
		
		// retrieve bean from spring container 
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
