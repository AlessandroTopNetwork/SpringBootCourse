package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.Employee;

public interface EmployeeServiceInterface {

	List<Employee> findAll();
	
	Employee findById(long id);
	
	Employee save(Employee employee);
	
	void delete(long id);
	
}
