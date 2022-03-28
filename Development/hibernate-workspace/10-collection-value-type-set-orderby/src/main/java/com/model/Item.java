package com.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
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
	@CollectionTable(
		name = "IMAGE",
		joinColumns = @JoinColumn(name = "ITEM_ID"))
	@Column(name = "FILENAME")
	@org.hibernate.annotations.OrderBy(clause = "FILENAME desc")
	protected Set<String> images = new LinkedHashSet<String>();

	public Item() {
		super();
	}

	public Item(String name, Set<String> images) {
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

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", images=" + images + "]";
	}
	
}
