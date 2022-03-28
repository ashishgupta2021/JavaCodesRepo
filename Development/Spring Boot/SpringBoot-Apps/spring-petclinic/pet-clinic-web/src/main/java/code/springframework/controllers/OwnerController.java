package code.springframework.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import code.springframework.model.Owner;
import code.springframework.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	

	@RequestMapping({"","/","/index","/index.html"})
	public String listOwners(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		System.out.println("------------------");
		Set<Owner> owners = ownerService.findAll();
		System.out.println(owners);
		return "owners/index";
	}
}
