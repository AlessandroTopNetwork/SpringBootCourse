package com.mapping.andavced;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mapping.andavced.dao.AppDAO;
import com.mapping.andavced.entity.Instructor;
import com.mapping.andavced.entity.InstructorDetail;

@SpringBootApplication
public class AndavcedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndavcedApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) { // auto inject by spring boot

		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			delteInstructor(appDAO);
			// detail
//			findInstructorDetail(appDAO);
//			createInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby", "darby@luv3code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv3code.com/youtube",
						"Luv 3 code!!!");
		*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu3", "Patel", "madhu@luv3code3.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv3code.com/youtube3",
						"Car");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
	
	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

	}
	
	private void deleteInstructor(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Delete instructor id: " + theId);

		appDAO.delteInstructorById(theId);

	}
	
	// istrructorDetail 
	
	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}
	
	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Delete instructorDetail id: " + theId);

		appDAO.delteInstructorDetailById(theId);

	}
	
	private void createInstructorDetail(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu3Detail", "Patel", "madhu@luv3code3.com");
		
		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv3code.com/youtube3Detail",
						"CarDetail", tempInstructor);
		
		tempInstructor.setInstructorDetail(tempInstructorDetail); // referencies obj for not lost obj

		// associate the objects
		tempInstructorDetail.setInstructor(tempInstructor);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructorDetail: " + tempInstructor);
		appDAO.save(tempInstructorDetail);

		System.out.println("Done!");
	}

}
