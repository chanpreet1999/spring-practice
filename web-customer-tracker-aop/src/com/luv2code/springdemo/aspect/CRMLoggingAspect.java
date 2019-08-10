package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {

	//set up logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//set up pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage(){}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage(){}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage(){}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow(){}
	
	//add @Before adivice
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint){
		
		//display method we are calling 
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("============>>>in @Berfore: calling method:"+method);
		
		//display arguments in method
		Object[] args=theJoinPoint.getArgs();
		
		//loop through the args
		for(Object temp:args){
			myLogger.info("Arguments Passed:"+temp);
		}
	}
	
	//add @AfterReturning Advice
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	private void Afterreturning(JoinPoint theJoinPoint,Object result ){
		//print calling method
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("===========>>>in @AfterReturnng: calling method:"+method);
		
		//print returned value 
		myLogger.info("Returned Value:"+result);
	}
}
