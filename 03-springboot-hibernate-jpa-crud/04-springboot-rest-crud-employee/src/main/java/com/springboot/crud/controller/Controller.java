package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.dao.EmployeeDAO;
import com.springboot.crud.entity.Employee;

@RestController
@RequestMapping("/api")
public class Controller {

	private EmployeeDAO employeeDAO;

	@Autowired
	public Controller(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	//get list employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return employeeDAO.findAll();
	}
	
	// get one employee
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeDAO.findById(id);
	}

}
