package com.exam02_RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		//return jdbcTemplate.queryForObject(sql, new VehicleRowMapper(), vehicleNo);
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Vehicle.class),vehicleNo);
		
	}
	@Override
	public List<Vehicle> findAll() {
		String sql = "SELECT * FROM VEHICLE";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(sql, new VehicleRowMapper());
	}
	@Override
	public String getColor(String vehicleNo) {
		String sql = "SELECT COLOR FROM VEHICLE WHERE VEHICLE_NO = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(sql, String.class, vehicleNo);
	}
	@Override
	public int countAll() {
		String sql = "SELECT COUNT(*) FROM VEHICLE";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
