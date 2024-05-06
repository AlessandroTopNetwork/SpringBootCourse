package com.onetomany.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onetomany.demo.entity.Course;
import com.onetomany.demo.entity.Instructor;
import com.onetomany.demo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bi-directional link
        //
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail
        entityManager.remove(tempInstructorDetail);
    }

	@Override
	public List<Course> findCoursesByIstructorId(int theIdIstructor) {
		TypedQuery<Course>  query = entityManager.createQuery(
				"from Course where instructor.id = :data", Course.class // select * is ommision string query and secondo arguments is class of entity to retrieve
				);
		
		query.setParameter("data", theIdIstructor); // set value of param into query thath name is first paramiter ("data")
		
		return query.getResultList();
	}

	@Override
	public Instructor findInstructorByIdFetchJoin(int theId) {
		TypedQuery<Instructor>  query = entityManager.createQuery(
				"select i from Instructor i " // alias instructor is i Instructor same name of class not table
				+ " join fetch i.courses" // JOIN FETCH to retrieve istructor and it list courses
				+ " where i.id= :data", Instructor.class
				);
		
		query.setParameter("data", theId);
		
		return query.getSingleResult();
	}
}







