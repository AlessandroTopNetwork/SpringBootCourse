package com.demo.restcontroller.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restcontroller.test.entity.Student;
import com.demo.restcontroller.test.entity.StudentError;

@RestController
@RequestMapping("/api")
public class ControllerRest {
	
	@GetMapping(value = "/hi")
	public String test() {
		return "hello world";
	}
	
	@GetMapping(value = "/getStudents")
	public List<Student> geStudents() {
		
		ArrayList<Student> listStudent = new ArrayList<Student>();
		
		listStudent.add(new Student("test", "test last name", "test email"));
		listStudent.add(new Student("iudsf", "test last test", "test"));
		listStudent.add(new Student("astrubale", "astrubale last name", "test astrubale email"));
		
		return listStudent;
	}
	
	// path varibale set value error on not find student
	@GetMapping(value = "/students/{studentId}")
	public Student studentsId0(
			@PathVariable int studentId) {
		
		Student student = null;
		
		ArrayList<Student> listStudent = new ArrayList<Student>();
		
		listStudent.add(new Student(0, "test", "test last name", "test email"));
		listStudent.add(new Student(1, "iudsf", "test last test", "test"));
		listStudent.add(new Student(2, "astrubale", "astrubale last name", "test astrubale email"));
		
		for(Student s : listStudent) {
			if(s.getId() == studentId) {
				student = s;
				break;
			} else {
				student = new Student(new StudentError(1, "student not found", 22));
			}
		}
		
		return student;
	}
	// from course
	@GetMapping(value = "/studentCourse/{studentId}")
	public Student studentsId1(
			@PathVariable int studentId) {
				
		ArrayList<Student> listStudent = new ArrayList<Student>();
		
		listStudent.add(new Student(0, "test", "test last name", "test email"));
		listStudent.add(new Student(1, "iudsf", "test last test", "test"));
		listStudent.add(new Student(2, "astrubale", "astrubale last name", "test astrubale email"));
		
		return listStudent.get(studentId);
	}
	
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<String> handleException(Exception ex) {
		 // Log the exception or perform other actions
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				 .body("Errore interno del server, errore : " + ex.getMessage());
	 }

}
