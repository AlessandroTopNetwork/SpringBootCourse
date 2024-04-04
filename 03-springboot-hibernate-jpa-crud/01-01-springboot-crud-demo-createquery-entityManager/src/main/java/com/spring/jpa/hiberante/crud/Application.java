package com.spring.jpa.hiberante.crud;

import java.util.List;

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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) { // quando il bean è inizializato allora lo esegue , subito dopo lo start application , quindi si comport come auto run che scrivo di solito con implements ApplicationListener<ApplicationReadyEvent> e la classe annotata come component
		return test -> {
			
			System.out.println("hello my friends");

//			searchEntity1(studentDAO);
			
			createStudents(studentDAO);
			
//			searchAllEntity(studentDAO);
			
//			searchSpecificEntity(studentDAO);
			
//			updateEntity(studentDAO);
			
//			deleteEntity(studentDAO);
			
//			deleteAll(studentDAO);
			
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
		
		Student studentTemp2 = new Student("papaperò", "01", "astr@nauto.test");
		Student studentTemp3 = new Student("palestra", "02", "power@polpaccio.femore");
		
		// save the student object
		studentDAO.save(studentTemp1);
		studentDAO.save(studentTemp0);
		
		studentDAO.save(studentTemp2);
		studentDAO.save(studentTemp3);
		
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
		Student studentTemp0 = studentDAO.findById(1);
		
		// display id of the saved student
		System.out.println("hello exampke course, object found : " + studentTemp0);
		
	}
	
	private void searchAllEntity(StudentDAO studentDAO) { // find all object
		
		System.out.println("start find all object of student example course");
		
		// find the student object
		List<Student> studentList = studentDAO.findAll();
		
		// display id of the saved student
		System.out.println("hello example course, object list found : " + studentList);
		
		for(Student s : studentList) {
			
			System.out.println(s);
			
		}
		
		
	}
	
	private void searchSpecificEntity(StudentDAO studentDAO) { // find specific object
		
		System.out.println("start find specific object of student example course");
		
		// find the student object
		List<Student> studentList = studentDAO.findByLastName("01");
		
		// display id of the saved student
		System.out.println("hello example course, object specific found : " + studentList);
		
	}
	
	private void updateEntity(StudentDAO studentDAO) { // find specific object
		
		System.out.println("start update object of student example course");
		
		// find the student object
		Student student = studentDAO.findById(1);
		
		// change first name 
		student.setFristName("Jhon");
		
		studentDAO.update(student);
		
		// display id of the saved student
		System.out.println("hello example course, object update : " + student);
		
	}
	
	private void deleteEntity(StudentDAO studentDAO) { // find specific object
		
		System.out.println("start delete object of student example course");
		
		// find the student object
		studentDAO.delete(3);
		
		searchAllEntity(studentDAO); // stamp in cosole data of database after delte record
		
		// display id of the saved student
		System.out.println("hello example course, object delete ");
		
	}
	
	
	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("start delete all record in studet table");
		
		int rowDelete = studentDAO.deleteAll();
		
		System.out.println("end delete all record in studet table , record delte : " + rowDelete);
	}
	
}


