package com.entity;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainApp {
	
	public static void main(String[] args) {
		
		// Create Object Mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// Read JSON file and map/convert to Java POJO: data/sample-lite.json
		try {
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println(theStudent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
