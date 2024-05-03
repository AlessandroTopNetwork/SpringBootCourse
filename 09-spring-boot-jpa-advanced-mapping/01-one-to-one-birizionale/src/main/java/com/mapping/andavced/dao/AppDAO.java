package com.mapping.andavced.dao;

import com.mapping.andavced.entity.Instructor;
import com.mapping.andavced.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    
    Instructor findInstructorById(int theId);
    
    void delteInstructorById(int theId);
    
    // detail table
    
    void save(InstructorDetail theInstructorDetail);
    
    void delteInstructorDetailById(int theId);
    
    InstructorDetail findInstructorDetailById(int theId);
    
}
