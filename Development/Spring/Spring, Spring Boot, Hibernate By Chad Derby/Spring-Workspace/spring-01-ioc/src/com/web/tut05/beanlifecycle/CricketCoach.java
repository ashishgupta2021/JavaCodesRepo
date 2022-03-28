package com.web.tut05.beanlifecycle;

public class CricketCoach implements Coach {

	// add new fields for emailaddress and team
	private String emailAddress;
	private String team;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public CricketCoach() {
		super();
	}

	@Override
	public String getDailyWorkout() {
		return "Practical fast bowling for 15 minutes";
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("CricketCoach.doMyStartupStuff()");
	}
	
	// add a destroy method
	public void doMyCleanUpStuff() {
		System.out.println("CricketCoach.doMyCleanUpStuff()");
	}
	

}
