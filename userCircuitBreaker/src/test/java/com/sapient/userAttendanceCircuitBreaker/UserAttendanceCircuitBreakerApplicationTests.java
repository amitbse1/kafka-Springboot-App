package com.sapient.userAttendanceCircuitBreaker;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sapient.userAttendanceCircuitBreaker.controller.UserAttendancecontroller;

@SpringBootTest
class UserAttendanceCircuitBreakerApplicationTests {

	
	@Mock
    private UserAttendancecontroller userService;
	
	@Test
	public void findAllUserTest() {
	    ResponseEntity<Object> found = userService.findAllUser();
	 
	     Assertions.assertNotNull(found);
	 }
}
