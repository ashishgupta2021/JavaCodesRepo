package com.exception;

import java.util.Date;

public class ReservationNotAvailableException extends RuntimeException
{
	private String courtName;
	private Date date;
	private int hour;
	
	public ReservationNotAvailableException(String courtName, Date date, int hour)
	{
		super();
		this.courtName = courtName;
		this.date = date;
		this.hour = hour;
	}

	public ReservationNotAvailableException()
	{
		super();
	}

	public String getCourtName()
	{
		return courtName;
	}

	public Date getDate()
	{
		return date;
	}

	public int getHour()
	{
		return hour;
	}
	
}
