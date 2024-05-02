package com.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	// only use to call custom page login security spring boot 
	
	@GetMapping("showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login2";
	}

}
