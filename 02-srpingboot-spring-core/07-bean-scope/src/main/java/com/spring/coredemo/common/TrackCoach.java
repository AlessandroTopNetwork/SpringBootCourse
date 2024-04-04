package com.spring.coredemo.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy // spring call this class if real need it , with out this annotations call this class any time
@Component
@Scope("prototype") // ConfigurableBeanFactory.SCOPE_PROTOTYPE
public class TrackCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "trackCoach test";
	}
	
	public TrackCoach() {
		System.out.println("in custoctor :" + getClass().getSimpleName());
	}

}
