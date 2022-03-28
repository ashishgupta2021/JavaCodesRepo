package com.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	
	public String getFortune() {
		
		// Simulate a dely
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Return a fortune
		return "Expect heavy traffic this morning";
	}

}
