package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.Course;

public interface CourseService {
	
	List<Course> findAll();
	
	Course findById(Long id);

}
