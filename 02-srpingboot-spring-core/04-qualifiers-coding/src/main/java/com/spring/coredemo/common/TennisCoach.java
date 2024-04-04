package com.spring.coredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "tennisCoach test";
	}

}
