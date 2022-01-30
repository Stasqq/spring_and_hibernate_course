package org.czobot.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

public interface Coach {
	
	public String getDailyWorkout();
	
	public String getDailyFortune();
}
