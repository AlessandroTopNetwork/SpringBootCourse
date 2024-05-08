package com.manytomany.demo.service;

import com.manytomany.demo.service.course.CourseService;
import com.manytomany.demo.service.student.StudentService;

public interface ServiceMain {
	
	CourseService getServiceCourse();
	
	StudentService getServiceStudent();

}
