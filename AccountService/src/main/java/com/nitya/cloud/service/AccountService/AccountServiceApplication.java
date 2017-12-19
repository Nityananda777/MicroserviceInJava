package com.nitya.cloud.service.AccountService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableZuulProxy
@EnableCircuitBreaker
public class AccountServiceApplication {

	@Value("${service.instance.name}")
	private String instance;

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@RequestMapping("/")
	public String message() {
		return "Hello India from " + instance;
	}

	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "callFallbackService")
	public String getMessage() {
		throw new RuntimeException("exception in fallback");
	}

	public String callFallbackService() {
		return "CIRCUIT BREAKER ENABLED!!!      ";
	}
}
