package com.example.thymeleaft.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// new a controller method to show initial html form
	
	@RequestMapping("/show-form") // default method type call is get
	public String showform() {
		return "helloworld-form";
	}
	
	// need a controller method to process the html form
	
	@RequestMapping("/processFrom")
	public String processForm() {
		return "helloworld";
	}

}
