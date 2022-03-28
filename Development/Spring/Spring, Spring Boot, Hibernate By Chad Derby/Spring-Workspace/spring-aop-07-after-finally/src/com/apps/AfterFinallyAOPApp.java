package com.apps;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AOPConfig;
import com.dao.AccountDAO;
import com.dao.MembershipDAO;
import com.entity.Account;

public class AfterFinallyAOPApp {

	public static void main(String[] args) {

		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		// Get the bean from spring conatiner
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Call method to find the accounts
		List<Account> theAccounts = null; 
		try {
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		// Display the accounts
		System.out.println(theAccounts);
		
		// Close the context
		context.close();
	}

}
