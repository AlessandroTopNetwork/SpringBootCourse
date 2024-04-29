package com.crud.demo.thymeleaft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.demo.thymeleaft.entity.Employee;
import com.crud.demo.thymeleaft.service.EmployeeService;

import jakarta.annotation.PreDestroy;

@Controller
@RequestMapping(value = "/employees")// api thymeleaft
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	@GetMapping({"/", ""}) // accpet list of path to call this endpoint
	public String index(){
		return "index";
	}
	
	// get list employees 
	
	@GetMapping("/list") // ommision value work any way
	public String listEmployees(Model model) {
		
		// get all employees from db
		List<Employee> listEmployee = employeeService.findAll();
		
		System.out.println(listEmployee);
		
		// add list to model spring boot to seend to html page thymeleaft ?
		model.addAttribute("employees", listEmployee); // frist param name of obj into html will be macth
		
		return "employees/list-employees";
	}
	
	// get html form add new employee
	
	@GetMapping("/form-add-employee")
	public String showFormAddEmployee(Model model) {
		
		model.addAttribute("employee", new Employee()); // set empty obj other ways null pointer into html on th:object="${employee}" :  Neither BindingResult nor plain target object for bean name 'employee' available as request attribute
		
		return "employees/form-add-employee";
	}
	
	// save employee
	
	@PostMapping("/save-employee")
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		
		employeeService.save(employee);
		
//		// reload main page list employee
//		
//		// get all employees from db
//		List<Employee> listEmployee = employeeService.findAll();
//		
//		// add list to model spring boot to seend to html page thymeleaft ?
//		model.addAttribute("employees", listEmployee); // frist param name of obj into html will be macth
		
		return "redirect:/employees/list"; // call endpoint to show table list of employees work fine
	}
	
	// get html modify employee
	
//	@GetMapping("/modify")
//	public String showModifyEmployee(@ModelAttribute Employee employee, Model model) {
//		
//		model.addAttribute("employee", employee);
//		
//		return "employees/modify";
//	}
	
	@GetMapping("/show-form-update")
	public String showModifyEmployee(@RequestParam("id") Long id, Model model) {
		
		System.out.println("id employee to update : " + id);
		
		Employee employee = employeeService.findById(id);
		
		model.addAttribute("employee", employee);
		
		return "employees/show-form-update";
	}
	
	// delete employee
	
	@GetMapping("/delete") // metodh put and delete sembra che non riesco a chiamalri da thymeleft
	public String deleteEmployee(@RequestParam Long id, Model model) {
		
		System.out.println("id to delete : " + id);
		
//		Long idToDelete = Long.parseLong(id);
		
		// delete employee
		employeeService.deleteById(id);
		
//		// call table and serach employee
//		
//		// get all employees from db
//		List<Employee> listEmployee = employeeService.findAll();
//		
//		// add list to model spring boot to seend to html page thymeleaft ?
//		model.addAttribute("employees", listEmployee); // frist param name of obj into html will b macth
		
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/exit-close")
	public void exit() {
		System.exit(1);
	}
	
	@PreDestroy
	public void testPreDestroyApp() { // work
		System.out.println("by by have a good day");
	}

}
