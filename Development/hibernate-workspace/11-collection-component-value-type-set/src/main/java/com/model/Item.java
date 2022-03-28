package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	protected String name;

	@ElementCollection
	@CollectionTable(name = "IMAGE")
	protected Set<Image> images = new HashSet<Image>();

	public Item() {
		super();
	}

	public Item(String name, Set<Image> images) {
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

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", images=" + images + "]";
	}
	
}
