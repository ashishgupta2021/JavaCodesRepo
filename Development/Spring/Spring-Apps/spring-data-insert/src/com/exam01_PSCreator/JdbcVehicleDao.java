package com.exam01_PSCreator;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Vehicle;

public class JdbcVehicleDao implements VehicleDao {

	private DataSource dataSource;
	
	public JdbcVehicleDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Vehicle vehicle) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(new InsertVehicleStatementCreator(vehicle));
	}
}
