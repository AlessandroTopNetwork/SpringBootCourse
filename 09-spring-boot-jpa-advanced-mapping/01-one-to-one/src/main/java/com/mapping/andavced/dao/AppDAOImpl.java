package com.mapping.andavced.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mapping.andavced.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
	public List<Instructor> delteInstructorById(int theId) {
		Instructor i = findInstructorById(theId);
		entityManager.remove(i);
		return findAll();
	}

	@Override
	public List<Instructor> findAll() {
//		Query q = entityManager.createQuery("SELECT id , first_name, last_name, email FROM instructor", Instructor.class);
		return null;
	}
    
}







