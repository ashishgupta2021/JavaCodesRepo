package com.withtemplate;


import java.util.Date;

public class Course {
	private Long id;
	private String title;
	private Date beginDate;
	private Date endDate;
	private int fee;
	
	public Course() {
	}
	
	public Course(Long id, String title, Date beginDate, Date endDate, int fee) {
		this.id = id;
		this.title = title;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.fee = fee;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getFee() {
		return fee;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", beginDate=" + beginDate + ", endDate=" + endDate + ", fee="
				+ fee + "]";
	}
	
	
}
