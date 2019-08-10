package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger= Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		
		//read spring config java class
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService theTrafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		myLogger.info("Main Program Around Advice");
		myLogger.info("Calling TrafficFortuneService\n");
		
		boolean tripWire=true;
		String trafficUpdate=theTrafficFortuneService.getFortune(tripWire);
		
		myLogger.info("Returned fortune:"+trafficUpdate);
		myLogger.info("Finished!");
		
		//close the context
		context.close();
	}

}
