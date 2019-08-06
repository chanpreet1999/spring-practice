package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMember(){
		System.out.println(getClass()+" ADD ACCOUNT:MEMBERSHIP DAO");
		return false;
	}

	public void goToSleep() {
		System.out.println(getClass()+" GOING TO SLEEP :MEMBERSHIP DAO");
		
	}
}
