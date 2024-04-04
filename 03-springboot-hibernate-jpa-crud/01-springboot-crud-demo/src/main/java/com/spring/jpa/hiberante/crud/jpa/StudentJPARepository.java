package com.spring.jpa.hiberante.crud.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.hiberante.crud.entity.Student;

public interface StudentJPARepository extends JpaRepository<Student, Integer>{
	
	Student findByEmail(String email);
	
	void removeByEmail(String email);

}
