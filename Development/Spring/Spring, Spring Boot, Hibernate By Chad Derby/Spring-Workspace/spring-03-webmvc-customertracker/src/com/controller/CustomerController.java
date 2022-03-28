package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Customer;
import com.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	
	// @RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model)	{
		
		List<Customer> customerList = customerService.getCustomers();
		
		// Add the customers to the model
		model.addAttribute("customers", customerList);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)	{
		
		// Create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustoemr(@ModelAttribute("customer") Customer theCustomer)	{
		
		// Save the customer using our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel)	{
		
		// Get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// Set customer as model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// Send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)	{
		
		// Delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
