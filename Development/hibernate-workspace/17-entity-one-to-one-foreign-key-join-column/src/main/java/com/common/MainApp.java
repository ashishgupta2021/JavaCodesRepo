package com.common;

import java.util.List;

import com.dao.UserDaoImpl;
import com.model.Address;
import com.model.User;

public class MainApp {
	
	public static void main(String[] args) {
		
		User user = new User("ashish_kumar",  "Ashish", "Gupta");
		Address address = new Address("Some Street 123", "560023", "Bangalore");
		user.setShippingAddress(address);
		testUser(user);
	}

	static void testUser(User user) 
	{
		UserDaoImpl userDao = new UserDaoImpl();		
		System.out.println(userDao.insert(user) != -1 ? "User Record inserted" : "User Record Not Inserted");
	}
}
