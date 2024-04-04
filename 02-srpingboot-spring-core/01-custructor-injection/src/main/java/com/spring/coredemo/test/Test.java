package com.spring.coredemo.test;

import org.springframework.stereotype.Component;

import com.spring.coredemo.interfacetest.Coach;

@Component // as a spring bean avaible for dependency injection
public class Test implements Coach{
	
	@Override
	public String getDalyWorkout() {
		return "zumba every day test aaa";
	}

}
