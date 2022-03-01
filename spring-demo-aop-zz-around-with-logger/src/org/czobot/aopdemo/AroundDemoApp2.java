package org.czobot.aopdemo;

import org.czobot.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp2 {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get accoutnDAO bean from spring container
		TrafficFortuneService fortuneService =
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain program: AroundDemoApp");

		System.out.println("Calling getFortune");
		
		String data = fortuneService.getFortune();
		
		System.out.println("\nMy forutne is: " + data);
		
		// close context
		context.close();
		
	}

}
