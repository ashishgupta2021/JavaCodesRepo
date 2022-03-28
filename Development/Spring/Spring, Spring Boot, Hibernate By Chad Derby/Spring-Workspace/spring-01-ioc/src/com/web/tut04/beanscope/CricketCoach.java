package com.web.tut04.beanscope;

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

}
