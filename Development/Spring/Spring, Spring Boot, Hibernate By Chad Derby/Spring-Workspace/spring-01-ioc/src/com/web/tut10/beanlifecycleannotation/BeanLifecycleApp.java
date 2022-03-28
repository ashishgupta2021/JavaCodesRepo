package com.web.tut10.beanlifecycleannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleApp {

	public static void main(String[] args) {

		
		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/web/tut10/beanlifecycleannotation/applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		
		
		
		// close the context 
		context.close();
	}

}
