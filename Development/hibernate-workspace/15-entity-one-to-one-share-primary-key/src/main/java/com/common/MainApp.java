package com.common;

import java.util.List;

import com.dao.AddressDaoImpl;
import com.dao.UserDaoImpl;
import com.model.Address;
import com.model.User;

public class MainApp {
	
	public static void main(String[] args) {
		Address address = new Address("Some Street 123", "560023", "Bangalore");
		testAddress(address);
	}
	
	static void testAddress(Address address) 
	{
		AddressDaoImpl addressDao = new AddressDaoImpl();		
		
		System.out.println(addressDao.insert(address) != -1 ? "Address Record inserted" : "Address Record Not Inserted");
		
		User user = new User(address.getId(), "ashish_kumar",  "Ashish", "Gupta", address);
		
		testUser(user, address);
		
	}

	static void testUser(User user, Address address) 
	{
		UserDaoImpl userDao = new UserDaoImpl();		
		System.out.println(userDao.insert(user) != -1 ? "User Record inserted" : "User Record Not Inserted");
				
		List<User> listUser = userDao.getAllUser();
		System.out.println("listUser :" + listUser);
	}
}
