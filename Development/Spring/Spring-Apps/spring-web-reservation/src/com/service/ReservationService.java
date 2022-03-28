package com.service;

import java.util.List;

import com.model.Reservation;
import com.model.SportType;

public interface ReservationService
{
	public List<Reservation> query(String courtName);
	public void make(Reservation reservation);
	public List<SportType> getAllSportTypes();
	public SportType getSportType(int sportTypeId);
}
