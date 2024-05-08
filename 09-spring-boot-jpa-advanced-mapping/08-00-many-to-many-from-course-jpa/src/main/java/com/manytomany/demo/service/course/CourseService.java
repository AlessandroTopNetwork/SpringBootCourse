package com.manytomany.demo.service.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.demo.entity.Course;
import com.manytomany.demo.jpa.CourseJpaRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseJpaRepository courseJpa;
	
	public List<Course> getAllCourse() {
		return courseJpa.findAll();
	}
	
	public Course findCourse(int id) {
		Optional<Course> c = courseJpa.findById(id);
		if(c.isPresent()) {
			return c.get();
		} else {
			return null;
		}
	
	}
	
	public List<Course> getListCourseByIDStudent(int id){
		return courseJpa.findByStudentsId(id);
	}
	
	public Course save(Course c) {
		return courseJpa.save(c);
	}
	
	public Course update(Course c) {
		return courseJpa.save(c);
	}
	
	public void delete(int id) {
		
		Optional<Course> c = courseJpa.findById(id);
		
		if(c.isPresent()) {
			courseJpa.delete(c.get());
		} else {
			System.err.println("course not found for id : " + id);
		}
		
		
	}

}
