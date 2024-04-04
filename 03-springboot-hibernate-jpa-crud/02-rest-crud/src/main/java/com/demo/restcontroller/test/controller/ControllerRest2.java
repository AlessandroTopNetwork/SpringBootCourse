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

import com.demo.restcontroller.test.customexception.StudentCustomException;
import com.demo.restcontroller.test.entity.Student;
import com.demo.restcontroller.test.entity.StudentError;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api2")
public class ControllerRest2 {
	
	ArrayList<Student> listStudent;
	
	@PostConstruct
	public void loadData() {
		
		listStudent = new ArrayList<Student>();
		
		listStudent.add(new Student(0, "test", "test last name", "test email"));
		listStudent.add(new Student(1, "iudsf", "test last test", "test"));
		listStudent.add(new Student(2, "astrubale", "astrubale last name", "test astrubale email"));
	}

	@GetMapping(value = "/hi")
	public String test() {
		return "hello world 2";
	}

	@GetMapping(value = "/getStudents")
	public List<Student> geStudents() {
		return listStudent;
	}

//	// path varibale set value error on not find student
//	@GetMapping(value = "/students/{studentId}")
//	public Student studentsId0(@PathVariable int studentId) {
//
//		Student student = null;
//
//		for (Student s : listStudent) {
//			if (s.getId() == studentId) {
//				student = s;
//				break;
//			} else {
//				student = new Student(new StudentError(404, "student not found", 22));
//			}
//		}
//
//		return student;
//	}

	// example from course
	@GetMapping(value = "/students/{studentId}")
	public Student studentsId1(@PathVariable int studentId) {
		
		if(studentId > listStudent.size() || studentId < 0) {
			throw new StudentCustomException("404 , student not found for id : " + studentId);
		}

		return listStudent.get(studentId);

	}

	//exception cathc gerneric , cathc genric excetion and response genric error
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception ex) {
//		// Log the exception or perform other actions
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				.body("Errore interno del server, errore : " + ex.getMessage());
//	}
	
	//from cousre
	// cacth specific exception studen
	@ExceptionHandler//(StudentCustomException.class)
	public ResponseEntity<StudentError> studentNotFoundException(StudentCustomException ex) {
		// Log the exception or perform other actions
		
		StudentError errorStudent = new StudentError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(errorStudent, HttpStatus.NOT_FOUND);
	}
	
	//from cousre
	// cacth specific exception student 
	@ExceptionHandler//(StudentCustomException.class)
	public ResponseEntity<StudentError> studentNotFoundException(Exception ex) {
		// Log the exception or perform other actions
		
		StudentError errorStudent = new StudentError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(errorStudent, HttpStatus.BAD_REQUEST);
	}

}
