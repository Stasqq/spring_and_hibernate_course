package org.czobot.aopdemo;

import java.util.logging.Logger;

import org.czobot.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundHandleExceptionDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get accoutnDAO bean from spring container
		TrafficFortuneService fortuneService =
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("\nMain program: AroundDemoApp");

		logger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = fortuneService.getFortune(true);
		
		logger.info("\nMy forutne is: " + data);
		
		// close context
		context.close();
		
	}

}
