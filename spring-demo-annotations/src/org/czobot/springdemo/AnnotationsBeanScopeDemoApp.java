package org.czobot.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanScopeDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		

		Coach secondCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println("\nPointing to the same object: " + (coach == secondCoach));
		
		System.out.println("\nMemory location for coach: " + coach);

		System.out.println("\nMemory location for secondCoach: " + secondCoach);
		
		// close the context
		context.close();
	}

}
