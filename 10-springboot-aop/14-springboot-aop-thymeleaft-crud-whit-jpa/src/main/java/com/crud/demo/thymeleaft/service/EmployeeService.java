package com.crud.demo.thymeleaft.service;

import java.util.List;

import com.crud.demo.thymeleaft.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(Long theId);

    Employee save(Employee theEmployee);

    void deleteById(Long theId);

}
