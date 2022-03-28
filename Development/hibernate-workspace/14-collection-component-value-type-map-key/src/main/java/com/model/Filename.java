package com.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Filename {

	@Column(nullable = false)
	protected String name;
	
	@Column(nullable = false)
	protected String extension;

	public Filename(String name, String extension) {
		super();
		this.name = name;
		this.extension = extension;
	}

	public Filename() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "Filename [name=" + name + ", extension=" + extension + "]";
	}
	
	
}