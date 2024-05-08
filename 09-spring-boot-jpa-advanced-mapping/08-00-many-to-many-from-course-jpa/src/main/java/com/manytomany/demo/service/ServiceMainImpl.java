package com.manytomany.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.demo.service.course.CourseService;
import com.manytomany.demo.service.student.StudentService;

@Service
public class ServiceMainImpl implements ServiceMain{
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentService studentService;

	public CourseService getServiceCourse() {
		return courseService;
	}

	public StudentService getServiceStudent() {
		return studentService;
	}

}
