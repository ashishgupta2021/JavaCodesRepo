package com.exam04_batchupdate;

import java.util.List;

import com.model.Vehicle;

public interface VehicleDao {
	public void insertBatch(List<Vehicle> vehicles);
}
