package com.exam02_RowMapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Vehicle;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		JdbcVehicleDao jdbcVehicleDao = (JdbcVehicleDao) context.getBean("vehicleDao");
		
		// Get Vehicle on Vehicle_No
		Vehicle vehicle = jdbcVehicleDao.findByVehicleNo("QEM0001");
		System.out.println("vehicle : " +vehicle);
		
		// Get All Vehicle 
		List<Vehicle> vehicles = jdbcVehicleDao.findAll();
		for(Vehicle veh : vehicles)
		System.out.println(veh);
		
		// Get Color of Vehile
		String color = jdbcVehicleDao.getColor("WEM0001");
		System.out.println("color : "+color);
		
		// Get No. of Rows of Vehicle
		int rowNums = jdbcVehicleDao.countAll();
		System.out.println("Total no. of Rows : "+rowNums);
	}
}
