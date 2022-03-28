package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	protected Long id;
	
	@OneToOne(
			fetch=FetchType.LAZY,
			optional = false
	)
	@PrimaryKeyJoinColumn
	protected Address shippingAddress;
	
	protected User() {}
	
	String userName;
	
	String firstName;
	
	String lastName;

	public User(Long id, String userName, String firstName, String lastName, Address shippingAddress) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", shippingAddress=" + shippingAddress + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	
	
}
