package com.springboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.entity.Student;

public interface StudentJPARepository extends JpaRepository<Student, Long>{

}
