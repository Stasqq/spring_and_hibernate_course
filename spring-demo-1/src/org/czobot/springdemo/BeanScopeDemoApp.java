package org.czobot.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach coach = context.getBean("coach", Coach.class);
		
		Coach secondCoach = context.getBean("coach", Coach.class);
		
		// check if they are the same
		boolean result = (coach == secondCoach);
		
		// print out the result
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for coach: " + coach);
	
		System.out.println("\nMemory location for coach: " + secondCoach + "\n");
		
		
		FootballCoach footballFirst = context.getBean("footballCoach", FootballCoach.class);
		
		FootballCoach footballSecond = context.getBean("footballCoach", FootballCoach.class);

		if (footballFirst == footballSecond) {
			System.out.println("Same beans");
		} else {
			System.out.println("Different beans");
		}
		
		// close the context
		context.close();
	}

}
