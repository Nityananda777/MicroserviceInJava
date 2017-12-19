package com.nitya.cloud.service.TimeAppService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class TimeAppServiceApplication {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(TimeAppServiceApplication.class, args);
	}
	@GetMapping("/")
	public String getMessage() {
		return "Inside TimeAppCientApplication" + new Date() + "port no " + port;
	}
}