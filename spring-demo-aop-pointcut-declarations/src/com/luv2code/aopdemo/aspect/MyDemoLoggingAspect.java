package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {


	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))") //all methods on dao package
	public void forDemoPackage(){} 
	
	//pointcut for getters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forGetter(){}
	
	//pointcut for setters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forSetter(){}
	
	//pointcut for all functions except getters setters in demo package
	@Pointcut("forDemoPackage() && !(forGetter() || forSetter())")
	public void forDaoPackageNoGetterSetter(){}
	
	
	@Before("forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n\n=====> Executing @Before advice on addAccount()");
	}
	 
	@Before("forDaoPackageNoGetterSetter()")
	public void performAnalytics(){
		System.out.println("=====>Performing API Analytics");
	}
	
}

