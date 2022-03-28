package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.model.FakeDataSource;
import com.model.FakeJmsSource;
import com.model.User;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")
})
public class PropertyConfig {
	
	// Not using Environment bean in this example
	@Autowired
	Environment env; 
	
	@Value("${my.username}")
	String username;
	
	@Value("${my.password}")
	String password;
	
	@Value("${my.dburl}")
	String url;
	
	@Value("${jms.username}")
	String jmsUsername;
	
	@Value("${jms.password}")
	String jmsPassword;
	
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUsername(username);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}	
	
	@Bean
	public FakeJmsSource FakeJmsSource() {
		FakeJmsSource fakeJmsSource = new FakeJmsSource();
		fakeJmsSource.setUsername(jmsUsername);
		fakeJmsSource.setPassword(jmsPassword);
		return fakeJmsSource;
	}
	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//		return propertySourcesPlaceholderConfigurer;
//	}
}
