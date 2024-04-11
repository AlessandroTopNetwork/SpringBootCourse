package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	private String basePath = "/api/employees";
	
	@Bean
	public InMemoryUserDetailsManager userDetailManager() { // add simple list of user to login for call endpoitn of EmployeeRestCOntroller
		
		UserDetails john = User.builder().
				username("john").
				password("{noop}test123").
				roles("EMPLOYEE").
				build();
		
		UserDetails mary = User.builder().
				username("mary").
				password("{noop}test123").
				roles("EMPLOYEE", "MANAGER").
				build();
		
		UserDetails susan = User.builder().
				username("susan").
				password("{noop}test123").
				roles("EMPLOYEE", "MANAGER", "ADMIN").
				build();
		
		return new InMemoryUserDetailsManager(john, mary, susan);
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // add check role of user login to access the many endpoint
		
		http.authorizeHttpRequests(configurer ->
				configurer
					.requestMatchers(HttpMethod.GET, basePath).hasRole("EMPLOYEE")
					.requestMatchers(HttpMethod.GET, basePath + "/**").hasRole("EMPLOYEE") // all path after base path
					.requestMatchers(HttpMethod.POST, basePath).hasRole("MANAGER")
					.requestMatchers(HttpMethod.PUT, basePath).hasRole("MANAGER")
					.requestMatchers(HttpMethod.DELETE, basePath + "/**").hasRole("ADMIN")
				);
		
		// use HTTP Basic authentication
		
		http.httpBasic(Customizer.withDefaults());
		
		// disable Cross Site Request Forgery (CSRF)
		// in general , not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}

}
