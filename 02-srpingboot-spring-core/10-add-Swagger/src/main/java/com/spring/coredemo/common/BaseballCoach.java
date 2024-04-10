package com.spring.coredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "baseBall test";
	}
	
	public BaseballCoach() {
		System.out.println("in custoctor :" + getClass().getSimpleName());
	}

}
