package com.spring.util;

import org.springframework.stereotype.Component;

@Component // as a spring bean avaible for dependency injection
public class Test implements Coach{
	
	@Override
	public String getDalyWorkout() {
		return "zumba every day test aaa";
	}

}
