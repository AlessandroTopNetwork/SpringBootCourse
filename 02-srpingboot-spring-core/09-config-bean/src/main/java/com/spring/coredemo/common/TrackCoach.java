package com.spring.coredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class TrackCoach implements Coach{
	
	public TrackCoach() {
		System.out.println("in custoctor :" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		return "trackCoach test";
	}

}
