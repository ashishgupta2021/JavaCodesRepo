package com.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// Create a Student Object
		Student theStudent = new Student();
		
		// Add Student object to the model
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent)	{
		
		System.out.println("theStudent " + theStudent.getFirstName() + " " +  theStudent.getLastName());
		
		return "student-confirmation";
	}

}
