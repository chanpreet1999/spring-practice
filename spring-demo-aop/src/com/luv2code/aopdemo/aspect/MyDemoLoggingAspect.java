package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	//@Before("execution( * add*())") any return type,called whenever any fuction starting with add is called
	
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") //first parameter is object of class account followed by any no of parameters
	
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") //all methods on dao package
	private void beforeAddAccountAdvice() {
		System.out.println("=====> Executing @Before advice on addAccount()");

	}
}
