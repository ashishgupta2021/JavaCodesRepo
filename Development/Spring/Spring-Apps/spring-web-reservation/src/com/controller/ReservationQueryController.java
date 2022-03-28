package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Reservation;
import com.service.ReservationService;

@Controller
@RequestMapping("reservationQuery")
public class ReservationQueryController
{
	private ReservationService reservationService;
	
	@Autowired
	public  void ReservationQueryController(ReservationService reservationService)
	{
		this.reservationService = reservationService;
	}
	
	/*	http://localhost:8080/spring-web/reservationQuery.do	*/
	@RequestMapping(method=RequestMethod.GET)
	public void setupForm() {
		System.out.println("ReservationQueryController.setupForm()");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@RequestParam("courtName") String courtName, Model model) {
		System.out.println("ReservationQueryController.submitForm()");
		System.out.println("courtName : "+courtName);
		List<Reservation> reservations = java.util.Collections.emptyList();
		if(courtName != null)	{
			reservations = reservationService.query(courtName);
			System.out.println(" reservations :" + reservations);
		}
		model.addAttribute("reservations",reservations);
		return "reservationQuery";
	}
}
