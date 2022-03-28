package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	protected String name;

	@ElementCollection
	@CollectionTable(name = "IMAGE")
	@Column(name = "FILENAME")
	@GenericGenerator(name="hilogen", strategy="increment")
	@org.hibernate.annotations.CollectionId(
			columns = @Column(name = "IMAGE_ID"),
			type = @org.hibernate.annotations.Type(type = "long"),
			generator = "hilogen"
	)
	protected Collection<String> images = new ArrayList<String>();

	public Item() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Item(String name, Collection<String> images) {
		super();
		this.name = name;
		this.images = images;
	}




	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Collection<String> getImages() {
		return images;
	}



	public void setImages(Collection<String> images) {
		this.images = images;
	}



	@Override
	public String toString() {
		return "Item [id=" + id + ", images=" + Arrays.toString(images.toArray()) + "]";
	}
	
}
