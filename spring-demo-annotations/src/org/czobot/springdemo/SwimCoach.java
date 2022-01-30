package org.czobot.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	@Value("${person.email}")
	private String email;
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "SwimCoach workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getEmail() {
		return email;
	}

}
