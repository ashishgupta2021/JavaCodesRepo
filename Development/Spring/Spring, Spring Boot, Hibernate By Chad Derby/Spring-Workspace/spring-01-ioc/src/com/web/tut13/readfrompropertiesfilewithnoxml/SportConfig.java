package com.web.tut13.readfrompropertiesfilewithnoxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.web.tut13.readfrompropertiesfilewithnoxml")
@PropertySource("classpath:com/web/tut13/readfrompropertiesfilewithnoxml/sport.properties")
public class SportConfig {	
	
	
	// Define a bean for our swim coach and inject dependency
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
