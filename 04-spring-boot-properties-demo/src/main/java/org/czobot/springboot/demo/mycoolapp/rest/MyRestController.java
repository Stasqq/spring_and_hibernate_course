package org.czobot.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	//inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + ", team name: " + teamName;
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on serwer is: " + LocalDateTime.now();
	}

	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run 5k";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucku day!";
	}
}