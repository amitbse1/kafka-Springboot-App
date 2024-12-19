package com.sapient.kafka;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.kafka.entity.TenantDetail;
import com.sapient.kafka.repository.TenantRepository;
import com.sapient.kafka.service.UserCommandService;


@SpringBootTest
class UserconsumerCommandApplicationTests {

	@Mock private TenantRepository attendanceRepository;

	@Autowired
	private UserCommandService attendanceService;

	@BeforeEach void setUp()
	{
		this.attendanceService
			= new UserCommandService(this.attendanceRepository);
	}

	
	@Test void addUser()
	{
		TenantDetail empattn = new TenantDetail("105", "JAN", "2023-04-02", "205", true, "08:10:00", "17:10:00");

		attendanceRepository.save(empattn);

	verify(attendanceRepository, times(1)).save(empattn);
	
	}
	
	
	@Test void updateUserTest()
	{
		TenantDetail empattn = new TenantDetail("105", "JAN", "2023-04-02", "205", true, "08:10:00", "17:10:00");

		attendanceRepository.save(empattn);
		
		attendanceService.updateUser("1012", true, "17:10:00", "2023-04-02");
		verify(attendanceRepository, times(1)).save(empattn);

		
	}
	
	@Test void updateUserAttendanceTest()
	{
		
		String updated = attendanceService.updateUser("1014", true, "17:10:00", "2023-04-02");
        Assertions.assertEquals(updated, "User update Failed");
		
	}
	
	
	
	
}
