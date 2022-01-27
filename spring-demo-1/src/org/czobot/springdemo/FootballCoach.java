package org.czobot.springdemo;

public class FootballCoach implements Coach {

	// define a private field for dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
		
	@Override
	public String getDailyWorkout() {
		return "FootballCoach workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
