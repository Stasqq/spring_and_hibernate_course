package org.czobot.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{

	@Value("${happy.fortune}")
	private String fortuneText;
	
	@PostConstruct
	private void initMethod() {
		System.out.println("HappyFortuneService fortuneText: " + fortuneText);
	}
	
	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
