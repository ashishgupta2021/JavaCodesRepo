package com.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Image {
	
	@Column(nullable = true)
	protected String title;
	
	protected int width;
	
	protected int height;

	public Image() {
	}

	public Image(String title, int width, int height) {
		super();
		this.title = title;
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Image [title=" + title + ", width=" + width + ", height=" + height + "]";
	}
}
