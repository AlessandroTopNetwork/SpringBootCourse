package com.spring.coredemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.util.Coach;

@RestController
public class Controller {
	
	private Coach myCoach;// = new Test(); the interface can inizializate class that implements it
	
	@Autowired
	public Controller(Coach myCoach) {
		this.myCoach = myCoach;
	}
	
	@GetMapping("/getDalyWorkout")
	public String getDalyWorkout() {
		return myCoach.getDalyWorkout();
	}
	
	@GetMapping("/")
	public String test() {
		return "test";
	}

}
