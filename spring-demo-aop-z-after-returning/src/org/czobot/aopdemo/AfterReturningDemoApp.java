package org.czobot.aopdemo;

import java.util.List;

import org.czobot.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get accoutnDAO bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();
		
		// display accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("=====");
		
		System.out.println(accounts);
		
		System.out.println("=====\n");
		
		// close context
		context.close();
		
	}

}
