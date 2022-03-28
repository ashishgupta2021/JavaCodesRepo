package com.exam02_RowMapper;

import java.util.List;

import com.model.Vehicle;

public interface VehicleDao {
	
	Vehicle findByVehicleNo(String vehicleNo); 
	List<Vehicle> findAll();
	String getColor(String vehicleNo);
	int countAll();
}	
