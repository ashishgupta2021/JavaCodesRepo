package com.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// http://localhost:8080/spring-02-mvc-demo/
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}

}
