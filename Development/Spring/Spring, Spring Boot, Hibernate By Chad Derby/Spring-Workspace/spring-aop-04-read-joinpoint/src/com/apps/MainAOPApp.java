package com.apps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AOPConfig;
import com.dao.AccountDAO;
import com.dao.MembershipDAO;
import com.entity.Account;

public class MainAOPApp {

	public static void main(String[] args) {

		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
		
		// Get the bean from spring conatiner
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Get Memebership bean from Spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// Calling the setter and getter method
		theAccountDAO.setName("MyAccount");
		theAccountDAO.setServiceCode("Account123");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		Account theAccount = new Account("SBI Account", "SBI123");
		// Call the business method
		theAccountDAO.addAccount(theAccount);
		
		// Call the membership business method
		theMembershipDAO.addAccount();
		
		// Close the context
		context.close();
	}

}
