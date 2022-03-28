package com.exam02_PSSetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Vehicle;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		
		VehicleDao vehicleDao = context.getBean(VehicleDao.class);
		Vehicle vehicle = new Vehicle("QEM0001","black",2,2);
		vehicleDao.insert(vehicle);
		System.out.println("Done");
	}
}
