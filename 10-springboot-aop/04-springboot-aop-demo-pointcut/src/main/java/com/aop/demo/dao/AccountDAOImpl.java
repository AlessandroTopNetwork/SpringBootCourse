package com.aop.demo.dao;

import org.springframework.stereotype.Repository;

import com.aop.demo.dto.AccountDto;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount() {
		
		System.out.println(getClass() + " hello add new Accoutn");
		
	}

	@Override
	public void updateAccount() {

		System.out.println(getClass() + " hello update Account methiod");
		
	}
	
	@Override
	public void addAccount(AccountDto accountDto) {
		System.out.println(getClass() + "hello from method with paramiter Account Dto" );
	}

}
