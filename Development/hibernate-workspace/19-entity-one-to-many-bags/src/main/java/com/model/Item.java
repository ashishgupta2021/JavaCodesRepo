package com.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    @OneToMany(mappedBy = "item")
    Collection<Bid> bids = new ArrayList<Bid>();

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

    public Collection<Bid> getBids() {
        return bids;
    }

    public void setBids(Collection<Bid> bids) {
        this.bids = bids;
    }

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", bids=" + bids + "]";
	}
    
    
	
}
