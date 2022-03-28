package code.springframework.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

	public String hello() {
		System.out.println("Hello!!!");
		return "hello";
	}
}
