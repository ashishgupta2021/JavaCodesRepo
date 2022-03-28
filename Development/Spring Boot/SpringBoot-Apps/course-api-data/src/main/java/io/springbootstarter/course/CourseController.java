package io.springbootstarter.course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	// http://localhost:8080/topics/101/courses/
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	// http://localhost:8080/topic/101/courses/java2
	@RequestMapping("/topic/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	// http://localhost:8080/topics/101/courses/
	/*
	 {
        "id": "course1",
        "name": "CS",
        "description": "Java Description"
     }
	 * */
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course , @PathVariable String topicId)	{
		System.out.println("CourseController.addCourse()");
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	/*
	 * http://localhost:8080/topics/101/courses/java2
	 {
        "id": "course1",
        "name": "CS",
        "description": "Java Description"
	 }
	 * */
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id)	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	// 	 http://localhost:8080/topics/topic101/courses/
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)	{
		System.out.println("CourseController.deleteTopic()");
		 courseService.deleteCourse(id);
	}
	
}
