package com.withtemplate;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(CourseConfiguration.class);
		CourseDao courseDao = context.getBean(CourseDao.class);
		
		Course course = new Course();
		course.setTitle("Core Spring");
		course.setBeginDate(new GregorianCalendar(2007,8,1).getTime());
		course.setEndDate(new GregorianCalendar(2007,9,1).getTime());
		course.setFee(1000);
	
		courseDao.store(course);
		
//		course.setTitle("Core Java");
//		course.setBeginDate(new GregorianCalendar(2007,8,1).getTime());
//		course.setEndDate(new GregorianCalendar(2007,9,1).getTime());
//		course.setFee(1000);
//		
//		courseDao.store(course);

		
		List<Course> courses = courseDao.findAll();
		System.out.println("courses : " + courses.size());
		
		Long courseId = courses.get(0).getId();
		
		course = courseDao.findById(courseId);
		
		System.out.println("Course Title :"+ course.getTitle());
		System.out.println("Begin Date : "+ course.getBeginDate());
		System.out.println("End Date :" + course.getEndDate());
		System.out.println("Fee : "+ course.getFee());
		
		
		
		//courseDao.delete(courseId);
	}
}
