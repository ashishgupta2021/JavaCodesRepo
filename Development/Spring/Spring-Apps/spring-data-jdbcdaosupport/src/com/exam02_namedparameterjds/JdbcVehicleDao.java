package com.exam02_namedparameterjds;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.model.Vehicle;

public class JdbcVehicleDao extends NamedParameterJdbcDaoSupport implements VehicleDao	{

	@Override
	public void insert(Vehicle vehicle) {
		String INSERT_QUERY = "insert into vehicle (vehicle_no, color, wheel, seat) values (:vehicleNo, :color, :wheel, :seat)";
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("vehicleNo", vehicle.getVehicleNo());
		parameters.put("color", vehicle.getColor());
		parameters.put("wheel", vehicle.getWheel());
		parameters.put("seat", vehicle.getSeat());
		
		getNamedParameterJdbcTemplate().update(INSERT_QUERY, parameters);
	}

}
