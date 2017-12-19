package com.nitya.cloud.serviceclient.TimeAppCient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name="timeservice")
public class TimeAppCientApplication {

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TimeAppCientApplication.class, args);
	}

	@RequestMapping("/")
	public String getData() {
		return restTemplate.getForEntity("http://TIMESERVICE", String.class).getBody();
	}
}
