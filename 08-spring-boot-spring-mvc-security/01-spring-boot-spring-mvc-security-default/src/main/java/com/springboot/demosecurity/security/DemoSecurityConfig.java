package com.springboot.demosecurity.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
	
	// config user to acceess endpoint or application , user mocekd in the code
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails jhon = User.builder()
				.username("jhon")
				.password("{noop}123test")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails mary = User.builder()
				.username("mary")
				.password("{noop}123test")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}123test")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(Arrays.asList(jhon, mary, susan));
		
	}

}
