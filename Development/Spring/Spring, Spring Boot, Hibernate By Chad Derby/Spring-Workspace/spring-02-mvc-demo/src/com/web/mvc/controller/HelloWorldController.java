package com.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	// http://localhost:8080/spring-02-mvc-demo/showForm
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// http://localhost:8080/spring-02-mvc-demo/processForm?studentName=Manish
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// http://localhost:8080/spring-02-mvc-demo/processFormVersionTwo?studentName=Ashish
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model)	{
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// Create the message
		String result = "Yo!" + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// http://localhost:8080/spring-02-mvc-demo/processFormVersionThree?studentName=Ashish
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name, Model model)	{
				
		// convert the data to all caps
		name = name.toUpperCase();
		
		// Create the message
		String result = "Hey! from V3 " + name;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
