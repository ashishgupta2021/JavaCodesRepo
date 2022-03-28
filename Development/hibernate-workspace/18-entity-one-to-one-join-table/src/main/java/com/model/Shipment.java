package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Shipment {

	@Id
	@GeneratedValue
	protected Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "ITEM_SHIPMENT", 
			   joinColumns = 
			   		@JoinColumn ( name = "SHIPMENT_ID"),
			   inverseJoinColumns =
			   		@JoinColumn( name = "ITEM_ID", nullable = false, unique = true)
	)
	protected Item auction;
	
	public Shipment() {}
	
	public Shipment(Item auction) {
		super();
		this.auction = auction;
	}

}
