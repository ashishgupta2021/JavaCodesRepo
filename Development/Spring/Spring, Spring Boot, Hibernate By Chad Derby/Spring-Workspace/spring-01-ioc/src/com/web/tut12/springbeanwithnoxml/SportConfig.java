package com.web.tut12.springbeanwithnoxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.web.tut12.springbeanwithnoxml")
@Configuration
public class SportConfig {

	// Define a bean for our sad fortune service
	
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Define a bean for our swim coach and inject dependency
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
