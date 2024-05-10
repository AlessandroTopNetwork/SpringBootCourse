package com.aop.demo.dao;

import org.springframework.stereotype.Repository;

import com.aop.demo.dto.AccountDto;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Repository
public class AccountDAOImpl implements AccountDAO{
	
	private String test, ciao;

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

	public String getTest() {
		System.out.println("get test");
		return test;
	}

	public void setTest(String test) {
		System.out.println("set test");
		this.test = test;
	}

	public String getCiao() {
		System.out.println("get ciao");
		return ciao;
	}

	public void setCiao(String ciao) {
		System.out.println("set coao");
		this.ciao = ciao;
	}
	
	

}
