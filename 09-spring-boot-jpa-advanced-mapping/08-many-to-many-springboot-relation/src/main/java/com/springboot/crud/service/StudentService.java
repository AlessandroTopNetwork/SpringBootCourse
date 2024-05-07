package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.Student;

public interface StudentService {

	List<Student> findAll();
	
	Student findById(Long id);
	
	Student save(Student employee);
	
	void delete(Long id);
	
}
