package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

	private static Logger myLogger=Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		//Print out method we are advising on 
		String method =theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("===>>>Executing Around Advice on method:"+method);
		
		//get begin timestamp
		long begin=System.currentTimeMillis();
		
		//now,let's execute the method
		Object result=null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			//log the message
			myLogger.warning(e.getMessage());
			
			//give a custom message
			//result="Highway closed but don't panic Helicoptor on the way";
			throw e;
		}
		
		//get end timestamp
		long end=System.currentTimeMillis();
		
		//compute duration and display it
		long duration=end-begin;
		myLogger.info("\n====>>>Duration:"+duration/1000);
		
		return result;
	}
	
	
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
					throwing="theExc"
					)
	public void AfterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc)
	{
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("+++++++++++Executing AfterThrowing on method+++++"+method);
		
		//log the exception
		myLogger.info("The Exception is:"+theExc);
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinally(JoinPoint theJoinPoint){
		myLogger.info("Executing after finally advice");
	}
	
}

