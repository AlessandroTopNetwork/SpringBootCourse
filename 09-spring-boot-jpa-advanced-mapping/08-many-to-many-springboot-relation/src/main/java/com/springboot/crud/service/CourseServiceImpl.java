package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.dao.CourseJPARepository;
import com.springboot.crud.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseJPARepository courseJpaRepository;

	@Override
	public List<Course> findAll() {
		return courseJpaRepository.findAll();
	}

	@Override
	public Course findById(Long id) {
		Optional<Course> c = courseJpaRepository.findById(id);
		
		if(c.isPresent()) {
			return c.get();
		} else { 
			return null;
		}
	}

}
