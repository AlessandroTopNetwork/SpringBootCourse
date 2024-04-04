package com.spring.jpa.hiberante.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.jpa.hiberante.crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class StudenetDAOImpl implements StudentDAO{
	
	// define filed for entity manager
	
	private EntityManager entityManager;
	
	// injection entity manager using constructor injection
	@Autowired// not strictly necessary
	public StudenetDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Object find(Class<?> entity, long id) { // find whit return genric object (need cast on call this method)
		return entityManager.find(entity, id);
	}

	@Override
	public <T> T find0(Class<T> entity, long id) { // find object with using generic Class<T> and retunr T object method
		return entityManager.find(entity, id);
	}

	@Override
	public Student find1(long id) {
		return entityManager.find(Student.class, id);
	}

}
