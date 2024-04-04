package com.spring.coredemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.coredemo.common.Coach;

@RestController
public class Controller {
	
	private Coach myCoach;// = new Test(); the interface can inizializate class that implements it
	
	@Autowired
	public Controller(@Qualifier("trackCoach") Coach theCoach) {
		this.myCoach = theCoach;
		System.out.println("in custoctor : " + getClass().getSimpleName());
	}
	
	@GetMapping("/getDailyWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	
	@GetMapping("/")
	public String test() {
		return "test";
	}

}
