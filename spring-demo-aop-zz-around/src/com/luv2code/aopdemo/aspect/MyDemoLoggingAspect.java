package com.luv2code.aopdemo.aspect;

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

	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		//Print out method we are advising on 
		String method =theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("===>>>Executing Around Advice on method:"+method);
		
		//get begin timestamp
		long begin=System.currentTimeMillis();
		
		//now,let's execute the method
		Object result=theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end=System.currentTimeMillis();
		
		//compute duration and display it
		long duration=end-begin;
		System.out.println("\n====>>>Duration:"+duration/1000);
		
		return result;
	}
	
	
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
					throwing="theExc"
					)
	public void AfterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc)
	{
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("+++++++++++Executing AfterThrowing on method+++++"+method);
		
		//log the exception
		System.out.println("The Exception is:"+theExc);
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinally(JoinPoint theJoinPoint){
		System.out.println("Executing after finally advice");
	}
	
}

