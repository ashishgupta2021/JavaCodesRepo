package com.exam01_rowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.model.Vehicle;

public class JdbcVehicleDao implements VehicleDao {

	private DataSource dataSource;
	
	public JdbcVehicleDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public Vehicle findByVehicleNo(String vehicleNo) {
		String sql = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		final Vehicle vehicle = new Vehicle();
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				vehicle.setVehicleNo(rs.getString("VEHICLE_NO"));
				vehicle.setColor(rs.getString("COLOR"));
				vehicle.setWheel(rs.getInt("WHEEL"));
				vehicle.setSeat(rs.getInt("SEAT"));
			}
		}, vehicleNo);
		return vehicle;
	}

}
