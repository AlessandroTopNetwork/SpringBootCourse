package com.spring.jpa.hiberante.crud.dao;

import java.util.List;

import com.spring.jpa.hiberante.crud.entity.Student;

public interface StudentDAO {
	
	// save
	
	void save(Student theStudent);
	
	// find object
	
	Object find(Class<?> entity, long id); // find object generic 
	
	<T> T find0(Class<T> entity, long id); // find object with using generic Class<T> and retunr T object method

	Student findById(long id); // example from course
	
	// find list object
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
	
	// update 
	
	void update(Student studentToUpdate);
	
	// delete
	
	void delete(long id);
	
	int deleteAll();
	
}
