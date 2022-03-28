package com.withouttemplate;

import java.util.GregorianCalendar;
import java.util.List;


public class Test {

	public static void main(String[] args) {
		CourseDao courseDao = new HibernateCourseDao();
		
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
		Long courseId = courses.get(0).getId();
		
		course = courseDao.findById(courseId);
		
		System.out.println("Course Title :"+ course.getTitle());
		System.out.println("Begin Date : "+ course.getBeginDate());
		System.out.println("End Date :" + course.getEndDate());
		System.out.println("Fee : "+ course.getFee());
		
		//courseDao.delete(courseId);
	}
}
