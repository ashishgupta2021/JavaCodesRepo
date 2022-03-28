package com.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan({"com.config", "com.controller","com.security.config"})
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	
	// Set up variable to hold the properties
	@Autowired
	private Environment env;
	
	// Set up a logger for diagnostic
	Logger logger = Logger.getLogger(getClass().getName());

	// Define a bean for ViewResolver
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// Define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource() {
		
		// Create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		// Set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		// Log the Connection Props
		logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));
		
		// Set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// Set Connection Pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	// Need a helper method
	// Read environment property and convert to int
	private int getIntProperty(String propName)	{
		
		String propVal = env.getProperty(propName);
		
		// Now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
}
