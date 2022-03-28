package com.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;

	// http://localhost:8000/currency-exchange/from/USD/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to)	{
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		log.info("retrieveExchangeValue called with {} to {}" ,from, to);
		System.out.println("currencyExchange : " + currencyExchange);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
