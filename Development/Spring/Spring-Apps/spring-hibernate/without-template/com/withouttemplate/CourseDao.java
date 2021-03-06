package com.withouttemplate;

import java.util.List;

public interface CourseDao {
	
	void store(Course course);
	void delete(Long courseId);
	Course findById(Long courseId);
	List<Course> findAll();
}
