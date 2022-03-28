package com.exam04_batchupdate;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class VehicleConfiguration {

	@Bean
	VehicleDao vehicleDao() {
		return new JdbcVehicleDao(dataSource());
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
