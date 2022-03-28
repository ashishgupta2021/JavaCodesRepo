package com.web.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
/*
 * Convenience annotation for clients to enable Hystrix circuit 
 * breakers (specifically). Use this (optionally) in case 
 * you want discovery and know for sure that it is Hystrix you want. 
 * All it does is turn on circuit breakers and let the 
 * autoconfiguration find the Hystrix classes if they are available 
 * (i.e. you need Hystrix on the classpath as well).

*/
@EnableHystrix
public class CloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

}
