package com.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="BD_TYPE")
public abstract class BillingDetails {

	@Id
	@GeneratedValue
	protected Long id;
	
	@NotNull
	private String owner;

	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", owner=" + owner + "]";
	}

	public BillingDetails() {
	}

	public BillingDetails(String owner) {
		super();
		this.owner = owner;
	}
}
