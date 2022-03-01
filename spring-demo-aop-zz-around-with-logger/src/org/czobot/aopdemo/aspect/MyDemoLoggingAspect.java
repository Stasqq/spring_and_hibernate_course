package org.czobot.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* org.czobot.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		
		logger.info("\n=====>>> Duration: " + duration/1000 + " seconds");
		
		return result;
	}
	
	@After("execution(* org.czobot.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @After (finally) on method: " + method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* org.czobot.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exception")
	public void afterThrowingFindAccountAdvice(
			JoinPoint joinPoint, Throwable exception) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		// log exception
		logger.info("\n=====>>> exception is: " + exception);
		
	}
	
	@AfterReturning(
			pointcut="execution(* org.czobot.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccoutnsAdvice(
			JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n=====>>> Executing @AfterReturning on method: " + method);
		
		// print out the result of the method call
		logger.info("\n=====>>> result is: " + result);
		
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
		logger.info("\n=====>>> Executing @Before advice on method");
		
		// display method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		
		logger.info("Method: " + methodSig);
		
		// display method argument
		
		// get args
		Object[] arguments = joinPoint.getArgs();
		
		// loop thru args
		for(Object arg: arguments) {
			logger.info("Argument: " + arg);
			
			if(arg instanceof Account) {
				// downcast and print Account specifics
				Account account = (Account) arg;
				
				logger.info("Account name: " + account.getName());
				logger.info("Account level: " + account.getLevel());
			}
		}
	}
	
}
