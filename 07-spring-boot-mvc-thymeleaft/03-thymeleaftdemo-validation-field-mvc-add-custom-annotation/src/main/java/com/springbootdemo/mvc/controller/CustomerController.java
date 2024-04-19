package com.springbootdemo.mvc.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootdemo.mvc.dto.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	
	@GetMapping("/show-form-customer")
	public String showForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@PostMapping("/processForm")
	private String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult
			) {
		
		System.out.println("the biding result : " + theBindingResult.toString());
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
		
	}
	
	// add initer binder to convert trim input string
	// remove leading and trailing white space
	// resole issue for our validation
	
	@InitBinder
	private void initBinder(WebDataBinder webDataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // trasnforma le string vuote in null
		
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor); // setti la proprieta dal binding web
		
	}
	

}
