package com.web.tut11.springconfigurationwithnoxml;

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
}
