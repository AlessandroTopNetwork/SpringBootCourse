package com.manytomany.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.demo.entity.Course;

public interface CourseJpaRepository extends JpaRepository<Course, Integer>{
	
	List<Course> findByStudentsId(int id);

}
