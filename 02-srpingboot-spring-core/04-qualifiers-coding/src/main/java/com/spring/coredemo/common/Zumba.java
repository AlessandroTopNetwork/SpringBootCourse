package com.spring.coredemo.common;

import org.springframework.stereotype.Component;

@Component // as a spring bean avaible for dependency injection
public class Zumba implements Coach{
	
	@Override
	public String getDailyWorkout() {
		return "zumba every day";
	}

}
