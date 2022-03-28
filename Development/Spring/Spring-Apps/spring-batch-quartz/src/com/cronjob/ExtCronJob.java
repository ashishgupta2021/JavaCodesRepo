package com.cronjob;


import javax.annotation.Resource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.dao.JdbcVehicleDao;
import com.dao.VehicleDao;
import com.model.Vehicle;

public class ExtCronJob extends QuartzJobBean {

	@Resource(name="vehicleDao")
	private JdbcVehicleDao vehicleDao;
	
	@Override
	protected void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {
		//vehicle.show();
		System.out.println("Start" + vehicleDao);
		int result = vehicleDao.countAll();
		System.out.println("ExtCronJob.executeInternal()" + result);
		
	}
}
