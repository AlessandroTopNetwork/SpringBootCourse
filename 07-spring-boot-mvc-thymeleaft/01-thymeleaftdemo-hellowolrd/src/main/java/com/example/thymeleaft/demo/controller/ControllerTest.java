package com.example.thymeleaft.demo.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {
	
	// create mapping endpoint
	
	@GetMapping(value = "/")
	public String getIndexTest(Model model) {
		model.addAttribute("theDate", LocalDateTime.now());
		return "index";
	}

}
