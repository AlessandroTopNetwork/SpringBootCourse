package com.example.thymeleaft.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	// new a controller method to show initial html form
	
	@RequestMapping("/show-form") // requestMapping will be accept any type of request (get,post,put ecc.)
	public String showform() {
		return "helloworld-form";
	}
	
	// need a controller method to process the html form
	
	@PostMapping("/processForm") // only accpet get request // if call this endpoint by athor type call will be exception code 405 (method y not supported)
	public String processForm() {
		return "helloworld";
	}
	
	// need a controller method to read from data
	// add data to the model
	
	@PostMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the html from
		String theName = request.getParameter("studentName"); // name of paramiter from the form
		
		// convert the data to upper case
		
		theName = theName.toUpperCase();
		
		// create the message
		
		String message = "Yo! version two " +  theName;
		
		// add message to the model
		
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	
	
	@PostMapping("/processFormVersionThree")
	public String processFormThree(@RequestParam(name = "studentName") String theName, // replace HttpServeltRequest with @RequestParam when name is name of field in html form
										Model model) {
				
		// convert the data to upper case
		
		theName = theName.toUpperCase();
		
		// create the message
		
		String message = "Yo! version three " +  theName;
		
		// add message to the model
		
		model.addAttribute("message", message);
		
		return "helloworld";
	}

}
