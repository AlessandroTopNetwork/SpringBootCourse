package com.manytomany.demo.service.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.demo.entity.Student;
import com.manytomany.demo.jpa.StudentJpaRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentJpaRepository studentJpa;
	
	public List<Student> getAllstudent() {
		return studentJpa.findAll();
	}
	
	public Student findStudent(int id) {
		Optional<Student> s = studentJpa.findById(id);
		if(s.isPresent()) {
			return s.get();
		} else {
			return null;
		}
	
	}
	
	public List<Student> getListStudentByIDCourse(int id){
		return studentJpa.findByCoursesId(id);
	}
	
	public Student save(Student s) {
		return studentJpa.save(s);
	}
	
	
	public Student update(Student s) {
		return studentJpa.save(s);
	}
	
	public void delete(int id) {
		
		Optional<Student> s = studentJpa.findById(id);
		
		if(s.isPresent()) {
			studentJpa.delete(s.get());
		} else {
			System.err.println("student not found for id : " + id);
		}
			
	}

}
