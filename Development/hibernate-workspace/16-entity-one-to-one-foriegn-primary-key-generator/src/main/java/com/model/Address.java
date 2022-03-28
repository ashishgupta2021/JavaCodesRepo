package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(generator = "addressKeyGenerator")
	@org.hibernate.annotations.GenericGenerator(
			name = "addressKeyGenerator",
			strategy = "foreign",
			parameters = @org.hibernate.annotations.Parameter(
					name = "property", value = "user"
			)
	)
	protected Long id;
	
	@NotNull
	protected String street;
	
	@NotNull
	protected String zipcode;
	
	@NotNull
	protected String city;
	
	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	protected User user;

	public Address() {
	}

	public Address(User user, String street, String zipcode, String city) {
		super();
		this.user = user;
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
