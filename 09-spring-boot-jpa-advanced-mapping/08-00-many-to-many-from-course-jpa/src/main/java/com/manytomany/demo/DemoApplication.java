package com.manytomany.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.manytomany.demo.entity.Course;
import com.manytomany.demo.entity.Student;
import com.manytomany.demo.service.ServiceMain;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ServiceMain serviceMain) {

		return runner -> {

//			 createCourseAndStudents(serviceMain);

//			 findCourseAndStudents(serviceMain);

			 findStudentAndCourses(serviceMain);

//			 addMoreCoursesForStudent(serviceMain);

//			 deleteCourse(serviceMain);

//			 deleteStudent(serviceMain);

		};
	}

	private void deleteStudent(ServiceMain serviceMain) {

		int theId = 2;
		System.out.println("Deleting student id: " + theId);

		serviceMain.getServiceStudent().delete(theId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(ServiceMain serviceMain) {

		int theId = 2;
		Student tempStudent = serviceMain.getServiceStudent().findStudent(theId); // search student with id 2

		// create more courses
		Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");
		
		// set list current course 
		
		tempStudent.setCourses(serviceMain.getServiceCourse().getListCourseByIDStudent(theId));

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		serviceMain.getServiceStudent().update(tempStudent);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(ServiceMain serviceMain) {

		int theId = 1;
		Student tempStudent = serviceMain.getServiceStudent().findStudent(theId);

		System.out.println("Loaded student: " + tempStudent);
		
//		List<Course> listCourse = serviceMain.getServiceCourse().getListCourseByIDStudent(theId);
		
		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(ServiceMain serviceMain) {

		int theId = 11;
		Course tempCourse = serviceMain.getServiceCourse().findCourse(theId);

		System.out.println("Loaded course: " + tempCourse);
		
//		List<Student> listStudent = serviceMain.getServiceStudent().getListStudentByIDCourse(theId); // lazy many to many
		
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(ServiceMain serviceMain) {

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");
		
		// create the students
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		serviceMain.getServiceCourse().save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(ServiceMain serviceMain) {

		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		serviceMain.getServiceCourse().delete(theId);

		System.out.println("Done!");
	}

}
