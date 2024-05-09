package com.aop.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

	@Override
	public void addAccount() {

		System.out.println(getClass() + " hello add account method");
		
	}

}
