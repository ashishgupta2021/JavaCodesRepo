package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class BillingDetails {

	@Id
	@GeneratedValue
	protected Long id;
	
	@NotNull
	private String owner;

	public BillingDetails() {
	}

	public BillingDetails(String owner) {
		super();
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", owner=" + owner + "]";
	}
}
