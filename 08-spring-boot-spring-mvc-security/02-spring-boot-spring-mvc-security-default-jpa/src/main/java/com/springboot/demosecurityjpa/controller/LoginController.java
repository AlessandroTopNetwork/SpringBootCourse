package com.springboot.demosecurityjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	// only use to call custom page login security spring boot 
	
	@GetMapping("showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login2";
	}
	
	// add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied(Model model) {
		return "/access-denied";
	}

}
