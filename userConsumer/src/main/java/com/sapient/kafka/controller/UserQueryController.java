package com.sapient.kafka.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.kafka.service.UserConsumerQueryService;
import com.sapient.kafka.util.UserConstants;

@RestController
@RequestMapping(path = "/attendancedetail")
//@ConditionalOnProperty(name = "app.write.enabled", havingValue = "false")
public class UserQueryController {

	@Autowired
	UserConsumerQueryService userservice;

	Logger logger = Logger.getLogger(UserQueryController.class.getName());

	@GetMapping(path = "/findAllDevice")
    public ResponseEntity<List<DeviceData>> getDeviceData(
            @RequestParam("tenant_id") String tenantId,
            @RequestParam("device_id") String deviceId) {

        List<DeviceData> deviceData = deviceDataService.getDeviceData(tenantId, deviceId);
        return ResponseEntity.ok(deviceData);
    }
	
	@GetMapping(path = "/findAllUserDetails")
	@ResponseBody
	public ResponseEntity<?> findAllUser() {
		HttpHeaders headers = new HttpHeaders();

		try {
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(userservice.findAllUser());
		} catch (Exception e) {
			headers.add("Message", "false");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers)
					.body(UserConstants.FAILED_TO_ADD_USER);
		}

	}

}
