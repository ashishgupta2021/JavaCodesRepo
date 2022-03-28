package com.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * Scans for interfaces that declare they are feign clients 
 * (via org.springframework.cloud.openfeign.FeignClient @FeignClient). 
 * Configures component scanning directives for use 
 * with org.springframework.context.annotation.Configuration @Configuration classes.
*/
@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
}
