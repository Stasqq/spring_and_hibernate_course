package org.czobot.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] fortunesArray = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	private final Random random = new Random();
	
	@Override
	public String getFortune() {
		return fortunesArray[random.nextInt(fortunesArray.length)];
	}

}
