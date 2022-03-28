package com.controller;

import java.net.Authenticator.RequestorType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exception.LoginException;
import com.model.User;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	/* The String login() works same as this one.*/
	
	/*@RequestMapping("/login")
	public void login() {
		System.out.println("LoginController.login()");
		//return "login";
	}
	*/
	
	/* The previous login() method is same as this one
	 * because by default it will return the bean as same 
	 * as method name i.e., login */
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		System.out.println("LoginController.login()");
		return "login";
	}
	
	/*	This is called from the login FORM */
	@RequestMapping(value="validatelogin", method=RequestMethod.POST)
	public String validateLogin(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		System.out.println("LoginController.validateLogin()");
		boolean validUser = loginService.validateLogin(new User(name,password));
		model.addAttribute("user", name);
		if(!validUser)	{
			return "login";
		}	
		return "home";
	}
	
	/*
	 * Request : http://localhost:8080/spring-web/delete/raj.do 
	 * 			 http://localhost:8080/spring-web/remove/raja.do 
	 * */
	@RequestMapping(value= {"remove/{user}","delete/{user}"}, method=RequestMethod.GET)
	public String removeUser(@PathVariable("user") String user) {
		System.out.println("LoginController.removeUser()");
		System.out.println("user :" +user);
		return "home";
	}
	
	
	
}