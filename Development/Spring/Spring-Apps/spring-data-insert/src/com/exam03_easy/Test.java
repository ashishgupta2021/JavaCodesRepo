package com.exam03_easy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Vehicle;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		JdbcVehicleDao jdbcVehicleDao = (JdbcVehicleDao) context.getBean("vehicleDao");
		Vehicle vehicle = new Vehicle("REM0002", "green", 3, 3);
		jdbcVehicleDao.insert(vehicle);
		System.out.println("Done");
	}
}
