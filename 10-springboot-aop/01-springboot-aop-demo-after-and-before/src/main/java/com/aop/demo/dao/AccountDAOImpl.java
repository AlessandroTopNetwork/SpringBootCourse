package com.aop.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount() {
		
		System.out.println(getClass() + " hello add new Accoutn");
		
	}

}
