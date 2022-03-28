package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	protected Long id;
	
	@OneToOne(
			mappedBy = "user",
			cascade = CascadeType.PERSIST
	)
	protected Address shippingAddress;
	
	protected User() {}
	
	String userName;
	
	String firstName;
	
	String lastName;

	public User(String userName, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", shippingAddress=" + shippingAddress + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	
	
	
}
