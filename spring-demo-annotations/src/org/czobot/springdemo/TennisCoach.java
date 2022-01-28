package org.czobot.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: default constructor");
	}
	
//	@Autowired
//	public TennisCoach(@Qualifier("happyFortuneService")FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "TennisCoach workout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// define a setter method
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("TennisCoach: setFortuneService");
		this.fortuneService = fortuneService;
	}

}
