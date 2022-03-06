package org.czobot.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

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