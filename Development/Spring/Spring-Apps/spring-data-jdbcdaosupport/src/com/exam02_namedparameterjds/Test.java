package com.exam02_namedparameterjds;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.Vehicle;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfiguration.class);
		VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
		vehicleDao.insert(new Vehicle("ZEM0002","pink2",4,4));
		System.out.println("Done");
	}
}
