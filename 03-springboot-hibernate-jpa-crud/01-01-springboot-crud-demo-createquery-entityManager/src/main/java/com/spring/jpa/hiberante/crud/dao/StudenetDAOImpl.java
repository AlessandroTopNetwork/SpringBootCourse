package com.spring.jpa.hiberante.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.jpa.hiberante.crud.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class StudenetDAOImpl implements StudentDAO{
	
	Student s = new Student();
	
	// define filed for entity manager
	
	private EntityManager entityManager;
	
	// injection entity manager using constructor injection
	@Autowired// not strictly necessary
	public StudenetDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional // sembra non scrivere finceh il metodo non ha finito il suo lavoro , all'uscita dal metodo allora esegue le scritture a db
	@Override
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		
//		s.getFristName().equals("test"); // andando in exception non esegue le scritture sicomme le scritture le esege a fine metodo
		
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
	public Student findById(long id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// create query find all
		TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName", Student.class); // name of table need macth with name class entity
		// order condition by name of varibale in class entity
		
		// return query result
		return query.getResultList();
		
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		// create query find all
		TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName = :theData", Student.class); // name of table need macth with name class entity
		
		// set paramiter to query
		query.setParameter("theData", lastName);
		
		// return query result
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student studentToUpdate) {
		entityManager.merge(studentToUpdate);
	}

	@Override
	@Transactional
	public void delete(long id) {
		
		// find the student object
		Student student = findById(id);
		
		// delete student
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		return entityManager.createQuery("DELETE FROM Student").executeUpdate();
	}

}
