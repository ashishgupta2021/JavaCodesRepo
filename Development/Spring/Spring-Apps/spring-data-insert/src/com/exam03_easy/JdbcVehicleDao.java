package com.exam03_easy;

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
		String insertQuery = "INSERT INTO VEHICLE(VEHICLE_NO, COLOR, WHEEL, SEAT) VALUES(?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(insertQuery, vehicle.getVehicleNo(),vehicle.getColor(),vehicle.getWheel(), vehicle.getSeat());
		System.out.println("JdbcVehicleDao.insert()");
	}
}
