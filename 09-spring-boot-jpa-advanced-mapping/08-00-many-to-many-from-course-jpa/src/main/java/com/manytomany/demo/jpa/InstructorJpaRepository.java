package com.manytomany.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.demo.entity.Instructor;

public interface InstructorJpaRepository extends JpaRepository<Instructor, Integer>{

}
