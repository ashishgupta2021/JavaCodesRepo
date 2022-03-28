package com.exam01_PSCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

import com.model.Vehicle;

public class InsertVehicleStatementCreator implements PreparedStatementCreator {

	private Vehicle vehicle;
		
	public InsertVehicleStatementCreator(Vehicle vehicle) {
		this.vehicle = vehicle;
	}



	@Override
	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		
		String insertQuery = "INSERT INTO VEHICLE(VEHICLE_NO, COLOR, WHEEL, SEAT) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(insertQuery);
		ps.setString(1, vehicle.getVehicleNo());
		ps.setString(2, vehicle.getColor());
		ps.setInt(3, vehicle.getWheel());
		ps.setInt(4, vehicle.getSeat());
		return ps;
	}

}
