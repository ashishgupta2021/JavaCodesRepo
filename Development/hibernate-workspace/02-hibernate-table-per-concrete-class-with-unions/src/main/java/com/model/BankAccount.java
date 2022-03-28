package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount extends BillingDetails {

	@NotNull
	protected String account;

	@NotNull
	protected String bankName;

	public BankAccount() {
	}

	public BankAccount(String owner) {
		super(owner);
	}

	public BankAccount(String owner, String account, String bankName) {
		super(owner);
		this.account = account;
		this.bankName = bankName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "BankAccount [account=" + account + ", bankName=" + bankName + "]";
	}

}
