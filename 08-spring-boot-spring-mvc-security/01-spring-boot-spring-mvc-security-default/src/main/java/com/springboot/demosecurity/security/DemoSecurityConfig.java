package com.springboot.demosecurity.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
	
	// custom login form
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer ->
				configurer
						.anyRequest().authenticated()
				)
				.formLogin(form ->
						form
						.loginPage("/showMyLoginPage") // page in the dir template to login page call it by endpoint in the controller
						.loginProcessingUrl("/authenticateTheUser") // payh of method to process authenticate user login form will be free by spring boot
						.permitAll()
				)
				.logout(logout ->
						logout.permitAll()); // add support logout
		return http.build();
	
	}

}
