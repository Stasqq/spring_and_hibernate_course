package org.czobot.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
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
