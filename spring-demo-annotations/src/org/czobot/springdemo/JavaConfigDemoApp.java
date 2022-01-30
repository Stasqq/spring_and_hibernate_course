package org.czobot.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from spring container
		Coach coach = context.getBean("footballCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		Person person = context.getBean("person", Person.class);
		
		System.out.println("Person: " + person.toString());
		
		// close the context
		context.close();
	}

}
