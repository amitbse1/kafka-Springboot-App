package com.sapient.userAttendanceCircuitBreaker.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sapient.userAttendanceCircuitBreaker.util.UserAttendanceConstants;

@RestController
@RequestMapping(value = "/api")
public class UserAttendancecontroller {

	@Autowired
	private RestTemplate restTemplate;

	Logger logger = Logger.getLogger(UserAttendancecontroller.class.getName());

	@GetMapping(path = "/findAllUserAttendance")
	@HystrixCommand(fallbackMethod = "defaultFindAllUser")
	public ResponseEntity<Object> findAllUser() {

		String fooResourceUrl = UserAttendanceConstants.FIND_ALL_ATTEN_URL;

		// get object from consumer web service
		Object object = restTemplate.getForObject(fooResourceUrl, Object.class);
		logger.info(object.toString());

		return new ResponseEntity<Object>(object.toString(), HttpStatus.OK);

	}

	private ResponseEntity<Object> defaultFindAllUser() {
		logger.info(UserAttendanceConstants.CONSUMER_ERROR);

		String fallbackItem = new String(UserAttendanceConstants.CONSUMER_ERROR);

		return new ResponseEntity<Object>(fallbackItem, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}