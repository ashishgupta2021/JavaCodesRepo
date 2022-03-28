package com.exam02_PSSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import com.model.Vehicle;

public class InsertVehicleStatementSetter implements PreparedStatementSetter {

	private Vehicle vehicle;
	
	public InsertVehicleStatementSetter(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public InsertVehicleStatementSetter() {
	}

	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setString(1, vehicle.getVehicleNo());
		ps.setString(2, vehicle.getColor());
		ps.setInt(3, vehicle.getWheel());
		ps.setInt(4, vehicle.getSeat());
		
	}
}
