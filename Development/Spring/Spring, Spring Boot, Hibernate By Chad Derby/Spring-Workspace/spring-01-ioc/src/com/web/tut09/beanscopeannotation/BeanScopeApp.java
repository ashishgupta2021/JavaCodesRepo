package com.web.tut09.beanscopeannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	public static void main(String[] args) {

		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut09/beanscopeannotation/applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach otherCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if they are same
		
		System.out.println("Pointing to the same object: " + (theCoach == otherCoach));
		
		System.out.println("\n Memory location of theCoach: " + theCoach);
		System.out.println("\n Memory location of otherCoach: " + otherCoach);
		
		
		// close the context 
		context.close();
	}

}
