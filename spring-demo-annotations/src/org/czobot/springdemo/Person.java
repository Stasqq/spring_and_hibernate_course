package org.czobot.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value("${person.name}")
	private String name;
	
	@Value("${person.email}")
	private String email;

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + "]";
	}
}
