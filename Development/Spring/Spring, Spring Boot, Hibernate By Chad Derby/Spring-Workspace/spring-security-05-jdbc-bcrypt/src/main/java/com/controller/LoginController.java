package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		
		// return "plain-login";
		return "fancy-login";

	}
	
	// Add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		// return "plain-login";
		return "access-denied";

	}
}
