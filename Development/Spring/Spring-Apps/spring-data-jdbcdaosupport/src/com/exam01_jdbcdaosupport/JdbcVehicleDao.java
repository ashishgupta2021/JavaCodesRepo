package com.exam01_jdbcdaosupport;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.model.Vehicle;

public class JdbcVehicleDao extends JdbcDaoSupport implements VehicleDao {

	@Override
	public void insert(Vehicle vehicle) {
		String INSERT_QUERY = "Insert Into Vehicle(Vehicle_No, Color, Wheel, Seat) values (?, ?, ?, ?)";
		getJdbcTemplate().update(INSERT_QUERY, new Object[] { vehicle.getVehicleNo(), vehicle.getColor()
			, vehicle.getWheel(), vehicle.getSeat()});
	}

}
