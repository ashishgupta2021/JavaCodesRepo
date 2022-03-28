package com.exam03_namedparameterjds;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.model.Vehicle;

public class JdbcVehicleDao extends NamedParameterJdbcDaoSupport implements VehicleDao	{

	@Override
	public void insert(Vehicle vehicle) {
		String INSERT_QUERY = "insert into vehicle (vehicle_no, color, wheel, seat) values (:vehicleNo, :color, :wheel, :seat)";
		
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vehicle);
		
		getNamedParameterJdbcTemplate().update(INSERT_QUERY, parameterSource);
	}

}
