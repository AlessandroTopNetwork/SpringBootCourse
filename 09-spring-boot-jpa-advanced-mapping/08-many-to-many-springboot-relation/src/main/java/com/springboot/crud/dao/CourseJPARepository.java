package com.springboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.entity.Course;

public interface CourseJPARepository extends JpaRepository<Course, Long>{

}
