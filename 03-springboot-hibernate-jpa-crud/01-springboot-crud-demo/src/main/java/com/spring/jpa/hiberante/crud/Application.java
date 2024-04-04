package com.spring.jpa.hiberante.crud;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.jpa.hiberante.crud.dao.StudentDAO;
import com.spring.jpa.hiberante.crud.entity.Student;
import com.spring.jpa.hiberante.crud.jpa.StudentJPARepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	private StudentJPARepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return test -> {
			System.out.println("hello my friends");
		};
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunnerTestCallDbJpa(String[] args) {
//		return test -> {
//			System.out.println("hello my friends 2");
////			studentRepository.save(new Student());
////			System.out.println(studentRepository.findByEmail(null));
////			Student s = studentRepository.findById(2).isPresent() ? studentRepository.findById(2).get() : null;
////			
////			if(null != s) {
////				s.setEmail("test update email");
////			}
////			
////			studentRepository.save(s);
//			
//			studentRepository.removeByEmail("test update email");
//			
////			System.out.println(studentRepository.findById(1));
//		};
//	}
	
	@Bean
	public CommandLineRunner commandLineRunnerEntityManager(StudentDAO studentDAO) { // quando il bean è inizializato allora lo esegue , subito dopo lo start application , quindi si comport come auto run che scrivo di solito con implements ApplicationListener<ApplicationReadyEvent> e la classe annotata come component
		return test -> {
			System.out.println("hello my friends create method");
			createStudents(studentDAO);
		};
	}
	
	@Bean
	public CommandLineRunner commandLineRunnerEntityManagerSearch(StudentDAO studentDAO) { // quando il bean è inizializato allora lo esegue , subito dopo lo start application , quindi si comport come auto run che scrivo di solito con implements ApplicationListener<ApplicationReadyEvent> e la classe annotata come component
		return test -> {
			System.out.println("hello my friends search method");
			searchEntity1(studentDAO);
		};
	}
	
	private void createStudent(StudentDAO studentDAO) {
		
		// create the student object
		System.out.println("start create object of student");
		Student studentTemp = new Student("pippo", "pluto", "paperino@pap.qua");
		
		// save the student object
		studentDAO.save(studentTemp);
		
		// display id of the saved student
		System.out.println("hello id of object just now saved : " + studentTemp.getId());
		
	}
	
	private void createStudents(StudentDAO studentDAO) {
		
		// create the student object
		System.out.println("start create objects of student");
		Student studentTemp0 = new Student("papaperò", "astrubale", "astr@nauto.test");
		Student studentTemp1 = new Student("palestra", "bicipite", "power@polpaccio.femore");
		
		// save the student object
		studentDAO.save(studentTemp1);
		studentDAO.save(studentTemp0);
		
		// display id of the saved student
		System.out.println("hello id of object just now saved : " + studentTemp0.getId());
		
	}
	
	private void searchEntity(StudentDAO studentDAO) {
		
		System.out.println("start find object of student");
		
		// find the student object
		Student studentTemp0 = (Student) studentDAO.find(Student.class, 6);
		
		// display id of the saved student
		System.out.println("hello object found : " + studentTemp0);
		
	}
	
	private void searchEntity0(StudentDAO studentDAO) { // find object with using generic Class<T> and retunr T object method
		
		System.out.println("start find object of student");
		
		// find the student object
		Student studentTemp0 = studentDAO.find0(Student.class, 2);
		
		// display id of the saved student
		System.out.println("hello object found : " + studentTemp0);
		
	}

	private void searchEntity1(StudentDAO studentDAO) { // find object with using id primary key , example from course
		
		System.out.println("start find object of student example course");
		
		// find the student object
		Student studentTemp0 = studentDAO.find1(1);
		
		// display id of the saved student
		System.out.println("hello exampke course, object found : " + studentTemp0);
		
	}
	
}


