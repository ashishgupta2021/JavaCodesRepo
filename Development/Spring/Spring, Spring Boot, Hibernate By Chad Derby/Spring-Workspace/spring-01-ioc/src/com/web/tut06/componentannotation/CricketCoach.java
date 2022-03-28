package com.web.tut06.componentannotation;

import org.springframework.stereotype.Component;

@Component("MyCricketCoach")
public class CricketCoach implements Coach {

	public CricketCoach() {
		super();
	}

	@Override
	public String getDailyWorkout() {
		return "Cricket Coach Workout";
	}

}
