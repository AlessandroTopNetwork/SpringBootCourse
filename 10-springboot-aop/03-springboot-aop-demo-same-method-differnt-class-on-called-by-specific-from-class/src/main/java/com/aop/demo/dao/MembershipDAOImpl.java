package com.aop.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

	@Override
	public void addAccount() {

		System.out.println(getClass() + " hello add account method");
		
	}

	@Override
	public void addAccount(String a) {

		System.out.println(getClass() + "hello add account into MeberShip class whot one argusments");
		
	}

	@Override
	public void addAccount(String a, String b) {

		System.out.println(getClass() + "hello ass account into mebership class whit more argumemts");
		
	}

}
