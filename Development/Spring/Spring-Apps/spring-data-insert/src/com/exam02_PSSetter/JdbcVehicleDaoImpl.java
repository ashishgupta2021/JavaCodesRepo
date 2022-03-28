package com.exam02_PSSetter;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Vehicle;

public class JdbcVehicleDaoImpl implements VehicleDao {

	private DataSource dataSource;
	
	public JdbcVehicleDaoImpl(DataSource dataSource) {
			this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Vehicle vehicle) {
		String insertQuery = "INSERT INTO VEHICLE(VEHICLE_NO, COLOR, WHEEL, SEAT) VALUES(?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(insertQuery, new InsertVehicleStatementSetter(vehicle));
	}
}
