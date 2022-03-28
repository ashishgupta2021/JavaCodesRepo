package com.exam04_batchupdate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.Vehicle;

public class JdbcVehicleDao implements VehicleDao {

	private DataSource dataSource;
	
	JdbcVehicleDao(DataSource dataSource)	{
		this.dataSource = dataSource;
	}
	
	@Override
	public void insertBatch(List<Vehicle> vehicles) {
		String insertQuery = "INSERT INTO VEHICLE (VEHICLE_NO,COLOR, WHEEL, SEAT) VALUES ( ?, ?, ?, ?) ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.batchUpdate(insertQuery, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Vehicle vehicle = vehicles.get(i);
				ps.setString(1, vehicle.getVehicleNo());
				ps.setString(2, vehicle.getColor());
				ps.setInt(3, vehicle.getWheel());
				ps.setInt(4, vehicle.getSeat());
				
			}
			
			@Override
			public int getBatchSize() {
				return vehicles.size();
			}
		});
	}

}
