package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@NotNull
	protected String street;
	
	@NotNull
	protected String zipcode;
	
	@NotNull
	protected String city;

	public Address() {
	}

	public Address(String street, String zipcode, String city) {
		super();
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", zipcode=" + zipcode + ", city=" + city + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
