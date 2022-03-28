package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

	 @Id
	    @GeneratedValue
	    protected Long id;

	    @NotNull
	    protected String name;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "ITEM_BUYER",
	        joinColumns =
	            @JoinColumn(name = "ITEM_ID"), // Defaults to ID
	        inverseJoinColumns =
	            @JoinColumn() // Defaults to BUYER_ID
	    )
	    protected User buyer;

	    public Item() {
	    }

	    public Item(String name) {
	        this.name = name;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public User getBuyer() {
	        return buyer;
	    }

	    public void setBuyer(User buyer) {
	        this.buyer = buyer;
	    }
}
