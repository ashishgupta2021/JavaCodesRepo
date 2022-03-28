package com.model;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	protected String name;

	@ElementCollection
	@CollectionTable(name = "IMAGE")
	@Column(name = "FILENAME")
	@org.hibernate.annotations.SortNatural
	protected SortedSet<String> images = new TreeSet<String>();

	public Item() {
		super();
	}

	public Item(String name, SortedSet<String> images) {
		super();
		this.name = name;
		this.images = images;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SortedSet<String> getImages() {
		return images;
	}

	public void setImages(SortedSet<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", images=" + images + "]";
	}
	
}
