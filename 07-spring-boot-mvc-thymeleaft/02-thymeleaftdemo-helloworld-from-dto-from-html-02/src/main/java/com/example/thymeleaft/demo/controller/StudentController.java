package com.example.thymeleaft.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleaft.demo.dto.Student;

@Controller
public class StudentController {
	
	// new a controller method to show initial html form
	
	@GetMapping("/showStudentForm") // requestMapping will be accept any type of request (get,post,put ecc.)
	public String showform(Model model) {
		
		// create student obj and add it into model attribute
		
		model.addAttribute("student", new Student()); // seend empty obj because another ways will be return null obj // name attribute will be match with th:object in the page html
		
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute("student") Student student) {
		
		// log the input
		System.out.println("student : " + student);
		
		//
		
		return "student-confirmation";
	}
	
	

}
