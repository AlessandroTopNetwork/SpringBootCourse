package com.springboot.demosecurityjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerSecurity {
	
	@GetMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	// add a request mapping /leaders
	@GetMapping("/leaders")
	public String showPageLeaders() {
		return "/leaders";
	}
	
	// add a request mapping /systems
	@GetMapping("/systems")
	public String showPageSystems() {
		return "/systems";
	}

	
}
