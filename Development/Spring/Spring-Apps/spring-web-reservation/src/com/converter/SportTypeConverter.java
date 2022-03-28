package com.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.model.SportType;
import com.service.ReservationService;

public class SportTypeConverter implements Converter<String, SportType>
{
	@Autowired
	private ReservationService reservationService;

	@Override
	public SportType convert(String source)
	{
		System.out.println("SportTypeConverter.convert() source : "+source);
		int sportTypeId = Integer.parseInt(source);
		SportType sportType = reservationService.getSportType(sportTypeId);
		return sportType;
	}

}
