package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccount=context.getBean("accountDAO",AccountDAO.class);
		
		//call the business method
		theAccount.addAccount();
		
		System.out.println("\nlet's call it again!\n");
		
		theAccount.addAccount();
		
		//close the context
		context.close();
	}

}
