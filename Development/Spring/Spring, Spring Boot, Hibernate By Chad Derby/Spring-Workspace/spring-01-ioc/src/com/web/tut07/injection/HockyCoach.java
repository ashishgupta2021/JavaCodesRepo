package com.web.tut07.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HockyCoach implements Coach {

	private FortuneService fortuneService;
	
	public HockyCoach() {
	}
	
	// Method Injection
	@Autowired
	public void methodInjection(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Hocky Coach Workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
