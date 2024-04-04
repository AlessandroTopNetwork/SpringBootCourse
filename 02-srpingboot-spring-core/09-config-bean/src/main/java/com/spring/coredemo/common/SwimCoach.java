package com.spring.coredemo.common;

public class SwimCoach implements Coach{
	
	public SwimCoach() {
		// TODO Auto-generated constructor stub
		System.out.println("in custructor : " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "swim 1000 metres as awram up";
	}

}
