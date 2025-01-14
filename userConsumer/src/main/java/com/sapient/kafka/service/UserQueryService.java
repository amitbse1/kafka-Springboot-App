package com.sapient.kafka.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.kafka.entity.TenantDetail;
import com.sapient.kafka.repository.TenantRepository;

@Service
public class UserQueryService {

	private TenantRepository attendancerepository;

	Logger logger = Logger.getLogger(UserConsumerQueryService.class.getName());

	@Autowired
	public UserQueryService(TenantRepository attendancerepository) {
		super();
		this.attendancerepository = attendancerepository;
	}

	public List<TenantDetail> findAllUser() {
		List<TenantDetail> attendanceList = (List<TenantDetail>) attendancerepository.findAll();

		if (attendanceList != null) {
			return attendanceList;
		}
		return null;
	}

	
}
