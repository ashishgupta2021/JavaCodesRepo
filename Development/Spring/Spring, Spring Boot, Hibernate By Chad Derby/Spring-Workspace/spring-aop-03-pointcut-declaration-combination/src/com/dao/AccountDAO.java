package com.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	
	public String getName() {
		System.out.println("AccountDAO.getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println("AccountDAO.setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println("AccountDAO.getServiceCode()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println("AccountDAO.setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount() {
		System.out.println(getClass() + " : Doing DB work: adding an account");
	}
}
