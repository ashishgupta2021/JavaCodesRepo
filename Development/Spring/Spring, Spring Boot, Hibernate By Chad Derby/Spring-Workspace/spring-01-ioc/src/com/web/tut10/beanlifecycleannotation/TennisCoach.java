package com.web.tut10.beanlifecycleannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class TennisCoach implements Coach {

	public TennisCoach() {
	}

	@Override
	public String getDailyWorkout() {
		return "Tennis Coach Workout";
	}
	
	// add an init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("CricketCoach.doMyStartupStuff()");
	}
	
	// add a destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("CricketCoach.doMyCleanUpStuff()");
	}
	

}
