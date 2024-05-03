package com.mapping.andavced.dao;

import com.mapping.andavced.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    
    Instructor findInstructorById(int theId);
    
    void delteInstructorById(int theId);
    
}
