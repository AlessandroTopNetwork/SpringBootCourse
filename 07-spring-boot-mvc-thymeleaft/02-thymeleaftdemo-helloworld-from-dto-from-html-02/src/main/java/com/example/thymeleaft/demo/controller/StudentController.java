package com.example.thymeleaft.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleaft.demo.dto.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")//same name of field in file application.properties
	List<String> countries; // i think is same to retive list to db
	
	@Value("${favorite.language}")
	List<String> languages;
	
	@Value("${favorite.system}") // name of var in application.properties
	List<String> systems;
	
	// new a controller method to show initial html form
	
	@GetMapping("/showStudentForm") // requestMapping will be accept any type of request (get,post,put ecc.)
	public String showform(Model model) {
		
		// create student obj and add it into model attribute
		
		model.addAttribute("student", new Student()); // seend empty obj because another ways will be return null obj // name attribute will be match with th:object in the page html
		
		// add list string to seend html student-form.html
		
		// drop dwon list in html country
		model.addAttribute("countries", countries);
		
		// radio button in html
		model.addAttribute("languages", languages);
		
		// 		checkbox in html , if there are many box selections thymelaft embeds them all in the favoriteSystem variable, separate the various values with a comma , example : "Windows,MacOs,Linux0"
		model.addAttribute("systems", systems); // "" name of var to seend in html , and , obj
		
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute("student") Student student) { // seend obj to another page (student-confirmation.html)
		
		// log the input
		System.out.println("student : " + student);
		
		return "student-confirmation";
	}
	
	

}
