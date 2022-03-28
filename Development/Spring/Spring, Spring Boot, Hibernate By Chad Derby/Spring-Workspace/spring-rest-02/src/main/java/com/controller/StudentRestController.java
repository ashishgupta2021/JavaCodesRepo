package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.entity.StudentErrorResponse;
import com.entity.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> listStudents = new ArrayList<>();

	// Define @PostConstruct to load the student data ... only once
	@PostConstruct
	public void loadData() {
		listStudents = new ArrayList<>();
		listStudents.add(new Student("Ashish", "Gupta"));
		listStudents.add(new Student("Maniish", "Gupta"));
	}

	// Define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return listStudents;
	}

	// Define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// just index into the list ... keep it simple for now

		// Check the studentId against list size
		if ((studentId >= listStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found -" + studentId);
		}

		return listStudents.get(studentId);
	}
	
	/*
	 * // Add an exception handler using @ExceptionHandler
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(StudentNotFoundException exec) {
	 * 
	 * // Create a StudentErrorResponse StudentErrorResponse error = new
	 * StudentErrorResponse(); error.setStatus(HttpStatus.NOT_FOUND.value());
	 * error.setMessage(exec.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * // Return ResponseEntity return new ResponseEntity<>(error,
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * // Add another exception handler ... to catch any exception (Catch All)
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(Exception exec) {
	 * 
	 * // Create a StudentErrorResponse StudentErrorResponse error = new
	 * StudentErrorResponse(); error.setStatus(HttpStatus.BAD_REQUEST.value());
	 * error.setMessage(exec.getMessage());
	 * error.setTimeStamp(System.currentTimeMillis());
	 * 
	 * // Return ResponseEntity return new ResponseEntity<>(error,
	 * HttpStatus.BAD_REQUEST); }
	 */
}
