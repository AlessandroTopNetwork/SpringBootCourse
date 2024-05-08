package com.manytomany.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.demo.entity.Student;

public interface StudentJpaRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByCoursesId(int id);

}
