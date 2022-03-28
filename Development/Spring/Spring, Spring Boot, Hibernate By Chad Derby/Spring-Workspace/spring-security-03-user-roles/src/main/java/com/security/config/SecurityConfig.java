package com.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

// Step 2: Create Spring Security Configuration

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/* Configure users (in memory, database, ldap, etc) */ 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Add our users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
		.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
		
	}

	/* Configure security of web paths in application, login, logout etc */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER") /* '/leaders/**' means leaders and its subdirectories */
			.antMatchers("/systems/**").hasRole("ADMIN")			
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}
	

}
