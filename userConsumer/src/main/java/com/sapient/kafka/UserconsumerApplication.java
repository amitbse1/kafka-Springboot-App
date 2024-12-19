package com.sapient.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserconsumerApplication.class, args);
	}
	
}
