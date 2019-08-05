package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

	@Before("execution(public void addAccount())")
	private void beforeAddAccountAdvice() {
		System.out.println("=====> Executing @Before advice on addAccount()");

	}
}
