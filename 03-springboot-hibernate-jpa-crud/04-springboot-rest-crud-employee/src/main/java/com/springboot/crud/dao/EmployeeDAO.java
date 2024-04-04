package com.springboot.crud.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.crud.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int id);

}
