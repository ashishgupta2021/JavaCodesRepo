package com.exam01_rowCallbackHandler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Vehicle;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		JdbcVehicleDao jdbcVehicleDao = (JdbcVehicleDao) context.getBean("vehicleDao");
		Vehicle vehicle = jdbcVehicleDao.findByVehicleNo("WEM0002");
		System.out.println("vehicle : " +vehicle);
	}
}
