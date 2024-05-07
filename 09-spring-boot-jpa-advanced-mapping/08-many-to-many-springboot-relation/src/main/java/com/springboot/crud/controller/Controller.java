package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entity.Student;
import com.springboot.crud.service.StudentService;

@RestController
@RequestMapping("/api")
public class Controller {
	
//	@Autowired
	private StudentService studentService;

	@Autowired
	public Controller(StudentService studentService) { // superfluo basta auto wired sulla interfaccia
		this.studentService = studentService;
	}
	
	// get

	//get list student
	@GetMapping("/student")
	public List<Student> getAllstudent() {
		return studentService.findAll();
	}
	
	// get one student
	@GetMapping("/student/{studentId}")
	public Student getstudent(@PathVariable long studentId) {
		Student student = studentService.findById(studentId);
		if(student == null) {
			throw new RuntimeException("student not found");
		}
		return studentService.findById(studentId);
	}
	
	// post
	@PostMapping("student")
	public Student savestudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	// put 
	
	@PutMapping("/student")
	public List<Student> modifystudent(@RequestBody Student student) {
		studentService.save(student);
		return studentService.findAll();
	}
	
	// delete 
	@DeleteMapping("/student/{id}")
	public List<Student> deletestudent(@PathVariable long id){
		studentService.delete(id);
		return studentService.findAll();
	}

}
