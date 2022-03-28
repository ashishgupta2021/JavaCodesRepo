package com.manual;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.manual.CourseDao;
import com.manual.HibernateCourseDao;

@Configuration
public class CourseConfiguration {

	@Bean
	public CourseDao courseDao() {
		return new HibernateCourseDao(sessionFactory().getObject());
	}
	
/*	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		return sessionFactoryBean;
	}*/
	
	/*@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		return sessionFactoryBean;
	}*/
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setMappingLocations(new ClassPathResource("com/manual/course.hbm.xml"));
		return sessionFactoryBean;
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", org.hibernate.dialect.MySQL55Dialect.class.getName());
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_recipes?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("ashish65536");
		return dataSource;
	}
}
