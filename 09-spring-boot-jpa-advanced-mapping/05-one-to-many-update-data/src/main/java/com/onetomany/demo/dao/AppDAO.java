package com.onetomany.demo.dao;

import java.util.List;

import com.onetomany.demo.entity.Course;
import com.onetomany.demo.entity.Instructor;
import com.onetomany.demo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
    
    List<Course> findCoursesByIstructorId(int theIdIstructor);
    
    Instructor findInstructorByIdFetchJoin(int theId);
    
    void update(Instructor instructor);

}













