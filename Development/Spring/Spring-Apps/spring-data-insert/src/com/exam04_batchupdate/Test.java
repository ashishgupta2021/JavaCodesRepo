package com.exam04_batchupdate;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Vehicle;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		JdbcVehicleDao jdbcVehicleDao = (JdbcVehicleDao) context.getBean("vehicleDao");
		Vehicle vehicle1 = new Vehicle("WEM0001","blue",5,5);
		Vehicle vehicle2 = new Vehicle("WEM0002","yellow",6,6);
		jdbcVehicleDao.insertBatch(Arrays.asList(vehicle1,vehicle2));
		System.out.println("Done");
	}
}
