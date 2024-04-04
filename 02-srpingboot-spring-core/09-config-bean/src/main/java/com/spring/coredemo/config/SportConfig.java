package com.spring.coredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.coredemo.common.Coach;
import com.spring.coredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	@Bean
	public Coach swimCoach() { // name of class init instance with first char low case
		return new SwimCoach();
	}

}
