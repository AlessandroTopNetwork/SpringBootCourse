package com.crud.demo.thymeleaft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crud.demo.thymeleaft.entity.Employee;
import com.crud.demo.thymeleaft.service.EmployeeService;

@Controller
//@RequestMapping(value = "/api")// api thymeleaft
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	@GetMapping({"/", ""})
	public String index(){
		return "index";
	}
	
	// get list employees 
	
	@GetMapping("/employees/list") // ommision value work any way
	public String listEmployees(Model model) {
		
		// get all employees from db
		List<Employee> listEmployee = employeeService.findAll();
		
		// add list to model spring boot to seend to html page thymeleaft ?
		model.addAttribute("employees", listEmployee); // frist param name of obj into html will be macth
		
		return "list-employees";
	}
	
	@GetMapping("/add-employee")
	public String callHtmlFormInsertNewEmployee(Model model) {
		return "add-employee";
	}
	
	@PostMapping("/save-employee")
	public String addEmployee(@RequestBody Employee employee, Model model) {
		
		employeeService.save(employee);
		
		// reload main page list employee
		
		// get all employees from db
		List<Employee> listEmployee = employeeService.findAll();
		
		// add list to model spring boot to seend to html page thymeleaft ?
		model.addAttribute("employees", listEmployee); // frist param name of obj into html will be macth
		
		return "list-employees";
	}
	
	@PutMapping("/modify")
	public String modifyEmployee(@ModelAttribute Employee employee, Model model) {
		
		model.addAttribute("employee", employee);
		
		return "modify";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(Model model, @PathVariable Long id) {
		
		// delete employee
		employeeService.deleteById(id);
		
		// call table and serach employee
		
		// get all employees from db
		List<Employee> listEmployee = employeeService.findAll();
		
		// add list to model spring boot to seend to html page thymeleaft ?
		model.addAttribute("employees", listEmployee); // frist param name of obj into html will b macth
		
		return "list-employees";
		
	}

}
