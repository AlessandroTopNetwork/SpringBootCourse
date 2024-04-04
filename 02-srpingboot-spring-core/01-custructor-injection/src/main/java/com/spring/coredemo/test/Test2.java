package com.spring.coredemo.test;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.coredemo.interfacetest.Coach;

@Primary
@Component // as a spring bean avaible for dependency injection
public class Test2 implements Coach{
	
	@Override
	public String getDalyWorkout() {
		return "zumba every day test aaa 2222";
	}

}
