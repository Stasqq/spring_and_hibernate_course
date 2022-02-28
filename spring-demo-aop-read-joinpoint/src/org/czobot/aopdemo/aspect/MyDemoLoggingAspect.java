package org.czobot.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.czobot.aopdemo.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("org.czobot.aopdemo.aspect.AopPointcuts.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		// display method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method argument
		
		// get args
		Object[] arguments = joinPoint.getArgs();
		
		// loop thru args
		for(Object arg: arguments) {
			System.out.println("Argument: " + arg);
			
			if(arg instanceof Account) {
				// downcast and print Account specifics
				Account account = (Account) arg;
				
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
	}
	
}
