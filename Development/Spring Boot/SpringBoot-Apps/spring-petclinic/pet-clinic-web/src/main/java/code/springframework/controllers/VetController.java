package code.springframework.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import code.springframework.model.Owner;
import code.springframework.model.Vet;
import code.springframework.services.VetService;

@Controller
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	@RequestMapping({"/vets","/vets/index","/vets/index.html"})
	public String listVets(Model model) {
		model.addAttribute("vets",vetService.findAll());
		System.out.println("------------------");
		Set<Vet> vets = vetService.findAll();
		System.out.println(vets);
		return "vets/index";
	}
}
