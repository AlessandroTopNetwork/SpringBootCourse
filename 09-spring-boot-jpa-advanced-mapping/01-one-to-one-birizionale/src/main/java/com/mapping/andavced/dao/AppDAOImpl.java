package com.mapping.andavced.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mapping.andavced.entity.Instructor;
import com.mapping.andavced.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
	@Autowired
    private EntityManager entityManager;

    // inject entity manager using constructor injection
//    @Autowired
//    public AppDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }
    
    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }
    
	@Override
	@Transactional
	public void delteInstructorById(int theId) {
		Instructor i = findInstructorById(theId);
		entityManager.remove(i);
	}
	
	// detail

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

	@Override
	@Transactional
	public void save(InstructorDetail theInstructorDetail) {
		entityManager.persist(theInstructorDetail);
	}

	@Override
	@Transactional
	public void delteInstructorDetailById(int theId) {
		InstructorDetail istructorDetail = findInstructorDetailById(theId);
		
		// delet associate istructor because you not can dele only istructor detail
		
		istructorDetail.getInstructor().setInstructorDetail(null); // remove associated id
		
		// lunch update before delte on obj associated
		
		entityManager.remove(istructorDetail);
		
	}
}







