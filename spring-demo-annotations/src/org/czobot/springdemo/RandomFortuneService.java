package org.czobot.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private Random random = new Random();
	
	private String[] data = {
			"Fortune 1",
			"Fortune 2",
			"Fortune 3",
	};
	
	@Override
	public String getFortune() {
		return data[random.nextInt(data.length)];
	}

}
