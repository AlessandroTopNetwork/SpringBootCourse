package com.onetomany.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.onetomany.demo.dao.AppDAO;
import com.onetomany.demo.entity.Course;
import com.onetomany.demo.entity.Instructor;
import com.onetomany.demo.entity.InstructorDetail;

@SpringBootApplication
public class DemoApplication {
	
	/*
	 * Default fecth type by relation
	 * 
	 * one to one EAGER
	 * 
	 * one to may LAZY
	 * 
	 * Many to one EAGER
	 * 
	 * MANY to many LAZY
	 * 
	 * */

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);
			
//			findInstructorWithCourses(appDAO);
			
//			findInstructorWithCoursesFetchTypeIntoQueryCustom(appDAO);
			
			updateCourse(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games"); // save before istructor detail after istructor and in fine course list in base Cascade persist

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
	
	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId); // error because one to many is lazy retive data and when call at row 96 getCourses will be have conncection session db clòosed and throw Excetion

		System.out.println("tempInstructor: " + tempInstructor);
		
		tempInstructor.setCourses(appDAO.findCoursesByIstructorId(theId)); // set list into istructor the list retrieve from query (because is retrieve lazy will be launch query manualy)
		
		System.out.println("the associated courses: " + tempInstructor.getCourses()); // by defaul relation from one to many is by default at facth type lazy and this will be throw an exception

		System.out.println("Done!");
	}
	
	private void findInstructorWithCoursesFetchTypeIntoQueryCustom(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorByIdFetchJoin(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}
	
	private void update(AppDAO appDAO) {
		
		int id = 1;
		
		Instructor instructor = appDAO.findInstructorById(id);
		
		System.out.println("start update instructor number : " + instructor.getId());
		
		instructor.setLastName("test01");
		
		appDAO.update(instructor);
		
		System.out.println("Done!");
		
	}
	
	private void updateCourseAle(AppDAO appDAO) { // work
		
		int id = 1;
		
		Instructor instructor = appDAO.findInstructorByIdFetchJoin(id);
		
		System.out.println("start update instructor course number : " + instructor.getCourses().size());
		
		instructor.getCourses().get(instructor.getCourses().size() -1).setTitle("testaiamo ultimo corso");
		
		appDAO.update(instructor);
		
		System.out.println("Done!");
		
	}
	
	private void updateCourse(AppDAO appDAO) { // work
		
		int id = 11;
		
		Course course = appDAO.findCourse(id);
		
		System.out.println("start update instructor course number : " +id);
		
		course.setTitle("testaiamo ultimo corso id 11");
		
		appDAO.updateCourse(course);
		
		System.out.println("Done!");
		
	}

}
