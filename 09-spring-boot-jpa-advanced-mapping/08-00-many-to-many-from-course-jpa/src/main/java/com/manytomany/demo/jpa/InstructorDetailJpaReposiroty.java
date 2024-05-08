package com.manytomany.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.demo.entity.InstructorDetail;

public interface InstructorDetailJpaReposiroty extends JpaRepository<InstructorDetail, Integer>{

}
