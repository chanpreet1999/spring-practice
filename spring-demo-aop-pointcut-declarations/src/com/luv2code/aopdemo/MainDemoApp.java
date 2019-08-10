package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO theAccount=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembership=context.getBean("membershipDAO",MembershipDAO.class);
		
		//call the business method
		theAccount.addAccount(new Account(),true);
		theAccount.randomMethod(3);
		
		System.out.println("\nlet's call membershipDAO!\n");
		
		theMembership.addSillyMember();
		theMembership.goToSleep();
		
		//call setters and getters
		theAccount.setName("chanpreet");
		theAccount.setServiceCode("service no 1");
		theAccount.getName();
		theAccount.getServiceCode();
		
		//close the context
		context.close();
	}

}
