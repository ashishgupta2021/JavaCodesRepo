 package com.web.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.department.entity.Department;
import com.web.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	// http://localhost:9001/departments/
	/*
	 {
	    "departmentName": "IT",
	    "departmentAddress":"3rd cross Jalahalli",
	    "departmentCode": "IT-006"
	}
	 * */
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department)	{
		log.info("DepartmentController saveDepartment()");
		return departmentService.saveDepartment(department);
	}
	
	// http://localhost:9001/departments/1/
	@GetMapping("/{id}")
	public Department findDepartment(@PathVariable("id") Long departmentId) {
		log.info("DepartmentController findDepartment()");
		return departmentService.findDepartmentById(departmentId);

	}
}
