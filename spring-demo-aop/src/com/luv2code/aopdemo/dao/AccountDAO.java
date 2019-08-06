package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount,boolean bool ){
		System.out.println(getClass()+" DOING MY DB WORK : ADDING AN ACCOUNT");
	}

	public void randomMethod(int i) {
		System.out.println(getClass()+" ACCOUNT DAO : DISPLAYING INT "+i);
		
	}
}
