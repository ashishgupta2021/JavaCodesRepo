package com.service.impl;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService	{

	@Override
	public boolean validateLogin(User user) {
		
		if(user != null) {
			if(user.getName().equals("ashish") && user.getPassword().equals("ashish"))
				return true;
		}
		return false;
	}

	
}
