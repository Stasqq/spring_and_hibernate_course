package org.czobot.springdemo;

public class TrackCoach implements Coach {

	// define a private field for dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "TrackCoach workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// add an init method
	public void initMethod() {
		System.out.println("TrackCoach: initMetod");
	}
	
	// add a destroy method
	public void destroyMethod() {
		System.out.println("TrackCoach: destroyMetod");
	}
}
