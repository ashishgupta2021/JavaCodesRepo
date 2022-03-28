package com.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	// http://localhost:8000/sample-api
	@GetMapping("/sample-api")
	public String sampleApi() {
		logger.info("sample-api");
		return "Sample API";
	}

	// if '@Retry(name="default")' is default then it try to hit the 'sample-api-2'
	// three times and after that only it throws an error.
	@GetMapping("/sample-api-2")
	@Retry(name = "default")
	public String sampleApi2() {
		logger.info("sample-api 2");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class);
		return forEntity.getBody();
	}

	// if '@Retry(name="default")' is default then it try to hit the 'sample-api-3'
	// 5 times as we've setup in the properties file and after that only it throws an error.
	@GetMapping("/sample-api-3")
	@Retry(name="sample-api-3" , fallbackMethod = "hardcodedResponse")
	public String sampleApi3() {
		logger.info("sample-api 3");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class);
		return forEntity.getBody();
	}
	
	// Using Circuit breaker
	@GetMapping("/sample-api-4")
	@CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
	public String sampleApi4() {
		logger.info("sample-api 4");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class);
		return forEntity.getBody();
	}
	
	// Using Rate Limit
	@GetMapping("/sample-api-5")
	@RateLimiter(name="default")
	public String sampleApi5() {
		logger.info("sample-api 5");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
//				String.class);
//		return forEntity.getBody();
		return "sample-api-5";
	}

	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
	
//	// 10s => 10000 calls to the sample api
//	@GetMapping("/rate-limiter-sample-api")
//	@RateLimiter(name="default")
//	public String rateLimiterSampleApi() {
//		logger.info("rate-limiter-sample-api");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//		return forEntity.getBody();
//	}
//	
//	@GetMapping("/bulk-head-sample-api")
//	@Bulkhead(name="default")
//	public String bulkHeadSampleApi() {
//		logger.info("bulk-head-sample-api");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//		return forEntity.getBody();
//	}
//	

}
