package com.springboot.demosecurityjpa.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
//	// config user to acceess endpoint or application , user mocekd in the code
//	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		
//		UserDetails jhon = User.builder()
//				.username("jhon")
//				.password("{noop}123test")
//				.roles("EMPLOYEE")
//				.build();
//		
//		UserDetails mary = User.builder()
//				.username("mary")
//				.password("{noop}123test")
//				.roles("EMPLOYEE", "MANAGER")
//				.build();
//		
//		UserDetails susan = User.builder()
//				.username("susan")
//				.password("{noop}123test")
//				.roles("EMPLOYEE", "MANAGER", "ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(Arrays.asList(jhon, mary, susan));
//		
//	}
	
	// jpa recuvera user to access application
	
	@Bean
	public UserDetailsManager userDetailManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		// need this if you have table whit name != user and authorities
		
		// define query to retive a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select * from members where user_id = ?"); // user_id is user_name varchar 
		
		// define query to retive authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select * from roles where user_id = ?"); // if use table authorities and it column defult it code not need
		
		return jdbcUserDetailsManager;
	}
	
	// custom login form
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer ->
				configurer
						.requestMatchers("/").hasRole("EMPLOYEE") // indicate who can access at specific path endpoint
						.requestMatchers("/leaders/**").hasRole("MANAGER") // restricted access to endpoint "/leaders" and it sub endpoint for only account manager
						.requestMatchers("/systems/**").hasRole("ADMIN")
						.anyRequest().authenticated()
				)
				.formLogin(form ->
						form
						.loginPage("/showMyLoginPage") // page in the dir template to login page call it by endpoint in the controller
						.loginProcessingUrl("/authenticateTheUser") // payh of method to process authenticate user login form will be free by spring boot
						.permitAll()
				)
				.logout(logout ->
						logout.permitAll())// add support logout
				// add custom page access denied for account x
				.exceptionHandling(configurer -> 
						configurer.accessDeniedPage("/access-denied")); 
		return http.build();
		
	}

}
