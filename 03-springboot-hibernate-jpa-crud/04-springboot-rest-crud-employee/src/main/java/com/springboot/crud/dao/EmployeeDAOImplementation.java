package com.springboot.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.crud.entity.Employee;

import jakarta.persistence.EntityManager;

//@Component // work
@Repository // work
public class EmployeeDAOImplementation implements EmployeeDAO {

	private EntityManager entityMenager;

	@Autowired
	public EmployeeDAOImplementation(EntityManager entityMenager) {
		this.entityMenager = entityMenager;
	}

	@Override
	public List<Employee> findAll() {
		return entityMenager.createQuery("from Employee", Employee.class).getResultList();
	}

	@Override
	public Employee findById(int id) {
		return entityMenager.find(Employee.class, id);
	}

}
