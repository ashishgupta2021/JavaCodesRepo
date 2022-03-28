package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	protected String name;

	@ElementCollection
	@CollectionTable(name = "IMAGE")
	@GenericGenerator(name="hilogen", strategy="increment")
	@org.hibernate.annotations.CollectionId(
			columns = @Column(name = "IMAGE_ID"),
			type = @org.hibernate.annotations.Type(type = "long"),
			generator = "hilogen"
	)
	protected Collection<Image> images = new ArrayList<Image>();

	public Item() {
		super();
	}

	public Item(String name, Collection<Image> images) {
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

	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", images=" + images + "]";
	}
	
}
