package com.web.tut06.componentannotation;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	public TennisCoach() {
		super();
	}

	@Override
	public String getDailyWorkout() {
		return "Tennis Coach Workout";
	}

}
