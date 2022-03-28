package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.model.User;

@Configuration
public class UserConfig {

	@Value("${username}")
	private String userName;
	
	@Bean
	public User user() {
		User user = new User();
		user.setUsername(userName);
		return user;
	}
}
