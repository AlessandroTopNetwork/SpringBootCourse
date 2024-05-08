package com.manytomany.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.demo.entity.Review;

public interface ReviewJpaRepository extends JpaRepository<Review, Integer>{

}
