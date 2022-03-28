package com.web.tut13.readfrompropertiesfilewithnoxml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach() {
	}

	@Override
	public String getDailyWorkout() {
		return "Swim Coach Workout";
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
}
