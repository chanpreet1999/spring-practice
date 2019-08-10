package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService theTrafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		System.out.println("Main Program Around Advice");
		System.out.println("Calling TrafficFortuneService\n");
		String trafficUpdate=theTrafficFortuneService.getFortune();
		System.out.println("Returned fortune:"+trafficUpdate);
		System.out.println("Finished!");
		
		//close the context
		context.close();
	}

}
