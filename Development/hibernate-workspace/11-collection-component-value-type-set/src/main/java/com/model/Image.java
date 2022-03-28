package com.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Image {
	
	@Column(nullable = false)
	protected String title;
	
	@Column(nullable = false)
	protected String filename;
	
	protected int width;
	
	protected int height;

	public Image() {
	}

	public Image(String title, String filename, int width, int height) {
		super();
		this.title = title;
		this.filename = filename;
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Image [title=" + title + ", filename=" + filename + ", width=" + width + ", height=" + height + "]";
	}
}
