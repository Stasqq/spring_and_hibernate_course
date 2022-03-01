package org.czobot.aopdemo;

import java.util.List;

import org.czobot.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get accoutnDAO bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> accounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program caught exception: " + e);
		}
		
		// display accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("=====");
		
		System.out.println(accounts);
		
		System.out.println("=====\n");
		
		// close context
		context.close();
		
	}

}
