package com.web.tut07.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	// Field Injection
	@Autowired
	private FortuneService fortuneService;
	
	public FootballCoach() {
	}

	@Override
	public String getDailyWorkout() {
		return "Football Coach Workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
