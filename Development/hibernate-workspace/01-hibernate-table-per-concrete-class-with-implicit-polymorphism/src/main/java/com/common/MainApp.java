package com.common;

import java.util.List;
import com.dao.*;
import com.model.*;

public class MainApp {
	
	public static void main(String[] args) {
		// testCreditCard();
		testBankAccount();
	}
	
	static void testCreditCard() 
	{
		CreditCardDaoImpl creditCardDaoImpl = new CreditCardDaoImpl();
		CreditCard creditCard = new CreditCard("Ashish", 22l, "123456789", "04/10/2019");
		int result = creditCardDaoImpl.insert(creditCard);
	
		// Get All Records
		List<CreditCard> allCreditCards = creditCardDaoImpl.getAllCreditCard();
		System.out.println(allCreditCards);
		
		// Update Record into Credit Card
		creditCardDaoImpl.update(2l);	
		
	}
	
	static void testBankAccount() {
		BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();
		BankAccount bankAccount = new BankAccount("Ashish", 21l, "123", "PNB");
		
		int result = bankAccountDao.insert(bankAccount);
		System.out.println(result != -1 ? "Successfully inserted" : "Record not inserted");
		
		bankAccountDao.getAllBankAccount().toString();
		bankAccountDao.update(1l);
	}
	
	
	
}
