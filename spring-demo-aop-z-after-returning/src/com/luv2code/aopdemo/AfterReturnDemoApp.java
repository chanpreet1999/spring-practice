package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturnDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccount=context.getBean("accountDAO",AccountDAO.class);
		
		List<Account>accounts=theAccount.findAccount();
		System.out.println("\n--------------Back to main-----------------------\n");
		System.out.println("=========>>>all accounts are:\n"+accounts);
		
		//close the context
		context.close();
	}

}
