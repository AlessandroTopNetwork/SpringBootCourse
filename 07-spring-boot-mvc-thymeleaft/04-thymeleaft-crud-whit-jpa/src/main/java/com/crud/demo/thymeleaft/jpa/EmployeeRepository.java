package com.crud.demo.thymeleaft.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.thymeleaft.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // that's it ... no need to write any code LOL!
	
	List<Employee> findAllByOrderByLastNameAsc();

}
