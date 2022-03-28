package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.entity.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	// Add a new method: findAccounts()
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// Simulate an exception
		if(tripWire) {
			throw new RuntimeException("Account Excpetion");
		}
		List<Account> myAccounts = new ArrayList<Account>();
		
		// Create sample accounts
		Account account1 = new Account("Ashish", "Silver");
		Account account2 = new Account("Manish", "Gold");
		Account account3 = new Account("Niraj", "Platinum");
		
		// Add them to our accounts list
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		
		
		return myAccounts;
	}
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

	public void addAccount(Account theAccount) {
		System.out.println(getClass() + " : Doing DB work: adding an account");
	}
}
