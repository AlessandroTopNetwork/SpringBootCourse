package com.course.springboot.demo.myapp.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	// injection properties fro : coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/propertiestest")
	public String propertiesTest() {
		return "CoachName : " + coachName + "\n"
				+ "Team name : "+ teamName;
	}
	
	@GetMapping("/")
	public String test() {
		return "ciao";
	}
	
	// on strat appliaction de-comment this second end point save class and see hot reload application
//	@GetMapping("/0")
//	public String test2() {
//		return "ciao2";
//	}

}
