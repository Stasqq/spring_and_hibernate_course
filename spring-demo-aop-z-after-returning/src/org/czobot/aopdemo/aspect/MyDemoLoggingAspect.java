package org.czobot.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* org.czobot.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccoutnsAdvice(
			JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the result of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		// let's post-process data
		
		// convert account names to uppercase
		convertAccountNamesToUpperCase(result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account account : result) {
			// get uppercase version of name
			String accountNameUpperCase = account.getName().toUpperCase();
			// update name of account
			account.setName(accountNameUpperCase);
		}
	}

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
