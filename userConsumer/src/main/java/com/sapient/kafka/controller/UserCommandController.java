package com.sapient.kafka.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.kafka.service.UserCommandService;
import com.sapient.kafka.util.UserConstants;

@RestController
@RequestMapping(path = "/attendancedetail")
//@ConditionalOnProperty(name = "app.write.enabled", havingValue = "true")
public class UserCommandController {

	@Autowired
	UserCommandService attendanceservice;

	Logger logger = Logger.getLogger(UserCommandController.class.getName());
	
	@PutMapping(path = "/updateattens")
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestParam String employeeid, @RequestParam Boolean available,@RequestParam String checkout,
			@RequestParam String date) {
		HttpHeaders headers = new HttpHeaders();

		try {
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers)
					.body(attendanceservice.updateUser(employeeid, available, checkout, date));
		} catch (Exception e) {
			headers.add("Message", "false");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers)
					.body(UserConstants.FAILED_TO_ADD_USER);
		}

	}
}
