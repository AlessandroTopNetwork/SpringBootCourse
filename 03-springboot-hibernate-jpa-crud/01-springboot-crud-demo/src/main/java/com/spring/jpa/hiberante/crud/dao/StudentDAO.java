package com.spring.jpa.hiberante.crud.dao;

import com.spring.jpa.hiberante.crud.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Object find(Class<?> entity, long id); // find object generic 
	
	<T> T find0(Class<T> entity, long id); // find object with using generic Class<T> and retunr T object method

	Student find1(long id); // example from course
	
}
