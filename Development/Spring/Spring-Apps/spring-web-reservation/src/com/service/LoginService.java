package com.service;

import org.springframework.stereotype.Service;

import com.model.User;


public interface LoginService {

	public boolean validateLogin(User user);
}
