package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/api")
public class Controller {
	
//	@Autowired
	private EmployeeServiceInterface employeeService;

	@Autowired
	public Controller(EmployeeServiceInterface employeeService) { // superfluo basta auto wired sulla interfaccia
		this.employeeService = employeeService;
	}
	
	// get

	//get list employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}
	
	// get one employee
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("employee not found");
		}
		return employeeService.findById(employeeId);
	}
	
	// post
	@PostMapping("employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	// put 
	
	@PutMapping("/employee")
	public List<Employee> modifyEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employeeService.findAll();
	}
	
	// delete 
	@DeleteMapping("/employee/{id}")
	public List<Employee> deleteEmployee(@PathVariable int id){
		employeeService.delete(id);
		return employeeService.findAll();
	}

}
