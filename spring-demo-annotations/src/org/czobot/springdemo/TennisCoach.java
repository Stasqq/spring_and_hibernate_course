package org.czobot.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
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
	
	@PostConstruct
	private void initMethod() {
		System.out.println("TennisCoach: initMethod");
	}
	
	@PreDestroy
	private void destroyMethod() {
		System.out.println("TennisCoach: destroyMethod");
	}
	
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
