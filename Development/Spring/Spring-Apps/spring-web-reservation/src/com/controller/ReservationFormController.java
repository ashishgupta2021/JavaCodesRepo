package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.model.Player;
import com.model.Reservation;
import com.model.SportType;
import com.service.ReservationService;
import com.validation.ReservationValidator;

@Controller
@RequestMapping("/reservationForm")
@SessionAttributes("reservation")
public class ReservationFormController	{

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationValidator reservationValidator;
	
	@ModelAttribute("sportTypes")
	public List<SportType> populateSportType() {
		return reservationService.getAllSportTypes();
	}
	
	/*	http://localhost:8080/spring-web/reservationForm.do	*/
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm(@RequestParam(required = false, value="username") String username ,Model model)	{
		System.out.println("ReservationFormController.setupForm()");
		Reservation reservation = new Reservation();
		reservation.setPlayer(new Player(username, null));
		model.addAttribute("reservation", reservation);
		return "reservationForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("reservation") @Validated Reservation reservation, BindingResult result, SessionStatus status)	{
		System.out.println("ReservationFormController.submitForm()");
		System.out.println(reservation.getDate());
		if(result.hasErrors() ) {
			return "reservationForm";
		}
		reservationService.make(reservation);
		return "redirect:reservationForm/reservationSuccess.do";
	}
	
	@RequestMapping(value="reservationSuccess",method=RequestMethod.GET)
	public String reservationSuccess() {
		System.out.println("ReservationFormController.reservationSuccess()");
		return "reservationSuccess";
	} 
	
	@InitBinder
	public void initBinder(WebDataBinder binder)	{
		System.out.println("ReservationFormController.initBinder()");
		binder.setValidator(reservationValidator);
	}
}
