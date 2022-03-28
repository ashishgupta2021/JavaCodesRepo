package com.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.user.User;
import com.web.user.ValueObject.ResponseTemplateVO;
import com.web.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j 
public class UserController {

	@Autowired
	private UserService userService;
	
	// http://localhost:9002/users/
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("UserController saveUser()");
		return userService.saveUser(user);
	}
	
	// http://localhost:9002/users/1
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("UserController getUserWithDepartment()");
		return userService.getUserWithDepartment(userId);
	}
	
	
	
	
}
