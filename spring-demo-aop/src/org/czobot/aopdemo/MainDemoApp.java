package org.czobot.aopdemo;

import org.czobot.aopdemo.dao.AccountDAO;
import org.czobot.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get accoutnDAO bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call business method
		accountDAO.addAccount();
		
		// get membership bean from spring container
		MembershipDAO membershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call membership business method
		membershipDAO.addAccount();
		
		// close context
		context.close();
		
	}

}
