package com.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import com.exception.ReservationNotAvailableException;
import com.model.Player;
import com.model.Reservation;
import com.model.SportType;
import com.service.ReservationService;

public class ReservationServiceImpl implements ReservationService
{
	public static final SportType TENNIS = new SportType(1, "Tennis");
	public static final SportType SOCCER = new SportType(2, "Soccer");
	List<Reservation> reservations;
	
	public ReservationServiceImpl()
	{
		reservations = new ArrayList<>();
		reservations.add(new Reservation("Tennis #1", new GregorianCalendar(2008, 0, 14).getTime(), 16, new Player("Roger", "N/A"),TENNIS));
		reservations.add(new Reservation("Tennis #2", new GregorianCalendar(2008, 0, 14).getTime(), 20, new Player("James", "N/A"), SOCCER));
	}

	@Override
	public List<Reservation> query(String courtName)
	{
		System.out.println("ReservationServiceImpl.query()");
		List<Reservation> result = new ArrayList<>();
		for(Reservation reservation : reservations)	{
			System.out.println(reservation.getCourtName() + " courtName : " + courtName);
			if(reservation.getCourtName().equals(courtName))
				result.add(reservation);
		}
		return result;
	}

	@Override
	public void make(Reservation reservation) throws ReservationNotAvailableException
	{
		for(Reservation made : reservations)
		{
			if(made.getCourtName().equals(reservation.getCourtName()) &&
			   made.getDate().equals(reservation.getDate()) && 
			   made.getHour() == reservation.getHour())	{
			   throw new ReservationNotAvailableException(reservation.getCourtName(),reservation.getDate(),reservation.getHour());
			}
		}
		reservations.add(reservation);
		for(Reservation tempReservation: reservations)
			System.out.println("reservation : "+ tempReservation);
	}

	@Override
	public List<SportType> getAllSportTypes()
	{
		
		return Arrays.asList(new SportType[] {TENNIS, SOCCER} );
	}

	@Override
	public SportType getSportType(int sportTypeId)
	{
		switch(sportTypeId) {
			case 1: return TENNIS;
			case 2: return SOCCER;
			default: return null;
		}
	}
	
	

}
