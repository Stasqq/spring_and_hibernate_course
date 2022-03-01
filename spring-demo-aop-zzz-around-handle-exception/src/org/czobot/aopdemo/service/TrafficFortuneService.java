package org.czobot.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		try {
			// simulate a delay
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// return fortune
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean tripWire) {
		
		// simulate exception if tripWire is true
		if(tripWire) {
			throw new RuntimeException("Highway is close!");
		}
		
		return getFortune();
	}
	
}
