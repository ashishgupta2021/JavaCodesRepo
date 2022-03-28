package com.exam01_PSCreator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Vehicle;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		
		VehicleDao vehicleDao = (VehicleDao) context.getBean("jdbcVehicleDao");
		Vehicle vehicle = new Vehicle("TEM0004", "Red", 4, 4);
		vehicleDao.insert(vehicle);
		System.out.println("Test.main() Done");
	}
	
}
