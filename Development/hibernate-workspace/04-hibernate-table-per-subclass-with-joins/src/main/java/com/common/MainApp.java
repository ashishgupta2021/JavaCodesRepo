package com.common;

import java.util.List;

import javax.persistence.EntityManager;

import com.dao.BankAccountDaoImpl;
import com.dao.BillingDetailsDaoImpl;
import com.dao.CreditCardDaoImpl;
import com.model.BankAccount;
import com.model.BillingDetails;
import com.model.CreditCard;

public class MainApp {
	
	public static void main(String[] args) {
		//testCreditCard();
		//testBankAccount();
		testBillingDetails();
	}
	
	static void testCreditCard() 
	{
		
		CreditCardDaoImpl creditCardDaoImpl = new CreditCardDaoImpl();
		CreditCard creditCard = new CreditCard("Ashish", "123456789", "04/10/2019");
		System.out.println("Insert");
		int result = creditCardDaoImpl.insert(creditCard);
		System.out.println("Insert Done");
		
		// Get All Records
		System.out.println("Select");
		List<CreditCard> allCreditCards = creditCardDaoImpl.getAllCreditCard();
		System.out.println(allCreditCards);
		System.out.println("Select Done");

	//	 Update Record into Credit Card
		System.out.println("Update");
		creditCardDaoImpl.update(1l);
		System.out.println("Update Done");
		
	}
	
	static void testBankAccount() {
		BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();
		BankAccount bankAccount = new BankAccount("Ashish", "123", "PNB");
		
		int result = bankAccountDao.insert(bankAccount);
		System.out.println(result != -1 ? "Successfully inserted" : "Record not inserted");
		
		bankAccountDao.getAllBankAccount().toString();
		bankAccountDao.update(3l);
	}
	
	static void testBillingDetails() {
		BillingDetailsDaoImpl billingDetailsDao = new BillingDetailsDaoImpl();
		billingDetailsDao.getAllBillingDetails();
	}
}
