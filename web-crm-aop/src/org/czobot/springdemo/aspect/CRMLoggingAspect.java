package org.czobot.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* org.czobot.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* org.czobot.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* org.czobot.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display calling method
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====>>> in @Before: calling method: " + method);
		
		// display the argument to the method
		
		// get the arguments
		Object[] args = joinPoint.getArgs();
		
		// loop thru and display args
		for(Object arg : args) {
			logger.info("=====>>> argument: " + arg);
		}
	}
	
	// add @AfterReturn advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturn(JoinPoint joinPoint, Object result) {
		
		// display returning method
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====>>> in @@AfterReturning: from method: " + method);
		
		// display data returned
		logger.info("=====>>> result: " + result);
		
	}
}
