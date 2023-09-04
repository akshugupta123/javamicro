package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@EnableCircuitBreaker
@SpringBootApplication
public class EbookstoreappConsumerEurekaRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreappConsumerEurekaRibbonHystrixApplication.class, args);
	}

}
