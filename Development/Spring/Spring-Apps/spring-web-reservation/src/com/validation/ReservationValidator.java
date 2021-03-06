package com.validation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.Reservation;

public class ReservationValidator implements Validator
{

	@Override
	public boolean supports(Class clazz)
	{
		return Reservation.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courtName", "required.courtName","Court name is required");
		ValidationUtils.rejectIfEmpty(errors, "date", "required.date","Date is required");
		ValidationUtils.rejectIfEmpty(errors, "hour", "required.hour", "Hour is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "player.name", "required.playerName","Player name is required");
		ValidationUtils.rejectIfEmpty(errors, "sportType", "required.sportType","Sport Type is required");
		
		Reservation reservation = (Reservation) target;
		Date date = reservation.getDate();
		int hour = reservation.getHour();
		if(date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)	{
				if(hour < 8 || hour > 22 ) {
					errors.reject("invalid.holidayHOur", "Invalid holiday hour.");
				}else {
					if(hour < 9 || hour > 21) {
						errors.reject("invalid.weekdayHOur", "Invalid weekday hour.");
					}
				}
			}
		}
	}

}
