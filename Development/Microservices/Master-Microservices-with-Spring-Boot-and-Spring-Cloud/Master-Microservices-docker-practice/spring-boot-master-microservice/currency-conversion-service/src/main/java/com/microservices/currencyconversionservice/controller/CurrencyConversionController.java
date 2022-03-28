package com.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currencyconversionservice.model.CurrencyConversion;
import com.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy prxoy;

	// http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/11
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to , @PathVariable BigDecimal quantity)	{
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		// localhost should be replace with currency-exchange as won't work in Docker
		String URL = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
	//	String URL = "http://currency-exchange:8000/currency-exchange/from/{from}/to/{to}";
		// RestTemplate used to call other Rest endpoint
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(URL, CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		// System.out.println("currencyConversion : " + currencyConversion + " currencyConversion.getConversionMutliple() : " + currencyConversion.getConversionMultiple() + " quantity :" + quantity);		
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment() + " Rest Temaplate");
	}
	
	// http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to , @PathVariable BigDecimal quantity)	{

		
		CurrencyConversion currencyConversion = prxoy.retrieveExchangeValue(from, to);
		System.out.println("currencyConversion : " + currencyConversion + " currencyConversion.getConversionMutliple() : " + currencyConversion.getConversionMultiple() + " quantity :" + quantity);		
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment()+ " Feign");
	}
}
