package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
	
}

