package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Employee;

@Controller
public class ExcelController {
	
	static List<Employee> getAllEmployee() {
		
		Employee employee = new Employee("Suraj", "Gupta", 2000000);
		Employee employee2 = new Employee("Vipin", "Kumar", 5000000);
		Employee employee3 = new Employee("Suraj3", "Gupta3", 2000000);
		Employee employee4 = new Employee("Vipin3", "Kumar3", 5000000);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(employee);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		return employees;
	}
	
	/*	localhost:8080/spring-excel-generate/generate/excel.htm	*/
	@RequestMapping(value="/generate/excel.htm", method=RequestMethod.GET)
	ModelAndView generateExcel() throws Exception {
		System.out.println("ExcelController.generateExcel()");
		
		List<Employee> employees = getAllEmployee();
		
		ModelAndView modelAndView = new ModelAndView("excelView","employees",employees);
		
		return modelAndView;
	}
	
	/*	http://localhost:8080/spring-excel-generate/generate/pdf.htm	*/
	@RequestMapping(value="/generate/pdf.htm", method=RequestMethod.GET)
	ModelAndView generatePdf()	{
		System.out.println("ExcelController.generatePdf()");
		List<Employee> employees = getAllEmployee();
		ModelAndView modelAndView = new  ModelAndView("pdfView","employees", employees);
		return modelAndView;
	}
	
	
}
