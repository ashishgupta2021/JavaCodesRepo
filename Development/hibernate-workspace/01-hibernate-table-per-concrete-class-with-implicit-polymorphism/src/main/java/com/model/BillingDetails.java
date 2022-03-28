package com.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetails {

	public BillingDetails() {
	}

	public BillingDetails(String owner) {
		super();
		this.owner = owner;
	}

	private String owner;

}
