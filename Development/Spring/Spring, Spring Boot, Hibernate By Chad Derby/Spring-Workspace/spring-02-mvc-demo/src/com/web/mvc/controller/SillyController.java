package com.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyController {

	// http://localhost:8080/spring-02-mvc-demo/silly/showForm
	@RequestMapping("/showForm")
	public String showForm() {
		return "silly-form";
	}
}
