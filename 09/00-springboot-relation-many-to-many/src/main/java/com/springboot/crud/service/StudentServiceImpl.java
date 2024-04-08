package com.springboot.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.springboot.crud.dao.StudentJPARepository;
import com.springboot.crud.entity.Course;
import com.springboot.crud.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

//	@Autowired
	private StudentJPARepository studentJpaRepository;

	@Autowired
	public StudentServiceImpl(StudentJPARepository studentDAO) {// superfluo basta auto wired sulla iterfaccia
		this.studentJpaRepository = studentDAO;
	}

	@Override
	public List<Student> findAll() {
		return studentJpaRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		return studentJpaRepository.findById(id).isPresent() ? studentJpaRepository.findById(id).get() : null;
	}

	@Override
	@Transactional
	public Student save(Student student) {
		
		if(null != student.getListCourse()) {
			for(Course c : student.getListCourse()) {
				student.addCourse(c);
				c.addStudent(student);
			}
		}
		
		studentJpaRepository.save(student); // cannot execute merge to save or modify record without @Transctional
		System.out.println("test transacional");
		return student;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Student empolyee = findById(id); // find record
		
		studentJpaRepository.delete(empolyee); // delete record
		
		System.out.println("test transactional");
		
//		studentDAO.delete(studentDAO.findById(id)); // find record and remove
	}

}
