package com.mapping.andavced.dao;

import java.util.List;

import com.mapping.andavced.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    
    Instructor findInstructorById(int theId);
    
    List<Instructor> delteInstructorById(int theId);
    
    List<Instructor> findAll();

}
