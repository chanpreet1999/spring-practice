package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccount=context.getBean("accountDAO",AccountDAO.class);
		
		List<Account>accounts=null;
		try{
			boolean tripWire=true;
			theAccount.findAccount(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program....caught exception  "+exc);
		}
		System.out.println("\n--------------Back to main-----------------------\n");
		System.out.println("=========>>>all accounts are:\n"+accounts);
		
		//close the context
		context.close();
	}

}
