package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public String getName() {
		System.out.println(getClass()+": WITHIN GET NAME");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": WITHIN SET NAME");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": WITHIN GET SERVICE CODE");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": WITHIN SET SERVICE CODE");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount,boolean bool ){
		System.out.println(getClass()+" DOING MY DB WORK : ADDING AN ACCOUNT\n\n");
	}

	public void randomMethod(int i) {
		System.out.println(getClass()+" ACCOUNT DAO : DISPLAYING INT "+i);
		
	}
}
