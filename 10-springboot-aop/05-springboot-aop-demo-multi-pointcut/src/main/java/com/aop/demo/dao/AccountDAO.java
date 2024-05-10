package com.aop.demo.dao;

import com.aop.demo.dto.AccountDto;

public interface AccountDAO {
	
	void addAccount();
	
	void updateAccount();
	
	void addAccount(AccountDto account);
	
	String getTest();
	
	void setTest(String test);
	
	String getCiao();
	
	void setCiao(String ciao);

}
