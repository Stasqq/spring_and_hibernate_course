package org.czobot.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String email;
	
	private String team;
	
	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg construtctor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setFortuneService");
		this.fortuneService = fortuneService;
	}

	public void setEmail(String email) {
		System.out.println("CricketCoach: inside setEmial");
		this.email = email;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setTeam");
		this.team = team;
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "CricketCoach workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}