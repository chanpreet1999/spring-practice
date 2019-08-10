package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("=====> Executing @Before advice on addAccount()");
		MethodSignature methodSign=(MethodSignature)theJoinPoint.getSignature();
		System.out.println("\nMethod Signature:"+methodSign+"\n");
		Object[] args=theJoinPoint.getArgs();
		for(Object tempArgs: args){
			System.out.println(tempArgs);
			if(tempArgs instanceof Account){
				Account tempAccount = (Account)tempArgs;;
				System.out.println("Account Name:"+tempAccount.getName());
				System.out.println("Account Level:"+tempAccount.getLevel());
			}
		}
	}
	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))"
					,returning="result"
					)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result)
	{
		//printout on which method we are advising on
		String mySignature=theJoinPoint.getSignature().toShortString();	
		System.out.println("\n==========>>>>>>>>Executing AfterReturning Advice on method"+mySignature);
		
		//printout the result of the method call
		System.out.println("===>>result is:"+result);
		System.out.println("Changing names to uppercase!");
		convertToUpperCase(result);
	}

	private void convertToUpperCase(List<Account> result) {
		for(Account temp:result){
			String upper=temp.getName().toUpperCase();
			temp.setName(upper);
		}
		
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
	
}

