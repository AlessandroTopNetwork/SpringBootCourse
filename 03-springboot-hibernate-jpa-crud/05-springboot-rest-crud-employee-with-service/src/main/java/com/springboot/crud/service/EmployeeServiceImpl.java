package com.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.dao.EmployeeDAO;
import com.springboot.crud.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {// superfluo basta auto wired sulla iterfaccia
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		Employee empolyee = employeeDAO.save(employee); // cannot execute merge to save or modify record without @Transctional
		System.out.println("test transacional");
		return employee;
	}

	@Override
	@Transactional
	public void delete(int id) {
		Employee empolyee = employeeDAO.findById(id); // find record
		
		employeeDAO.delete(empolyee); // delete record
		
		System.out.println("test transactional");
		
//		employeeDAO.delete(employeeDAO.findById(id)); // find record and remove
	}

}
