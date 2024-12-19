package com.sapient.kafka.service;

import java.time.LocalTime;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sapient.kafka.dto.User;
import com.sapient.kafka.entity.TenantDetail;
import com.sapient.kafka.repository.TenantRepository;
import com.sapient.kafka.util.UserConstants;

@Service
public class UserCommandService {

	private TenantRepository attendancerepository;

	Logger logger = Logger.getLogger(UserCommandService.class.getName());

	@Autowired
	public UserCommandService(TenantRepository attendancerepository) {
		super();
		this.attendancerepository = attendancerepository;
	}
	
	@KafkaListener(topics = UserConstants.USER_TOPIC, groupId = UserConstants.USER_TOPIC_GROUP_ID)
    public void listenFileUploadEvent(FileUploadEvent event) {
        try {
            String tenantId = event.getTenantId();
            String fileName = event.getFileName();
            String s3Bucket = event.getS3Bucket();

            // Retrieve file from S3
            InputStream fileInputStream = s3Service.downloadFile(tenantId, s3Bucket, fileName);

            // Process the file
            fileProcessingService.processFile(tenantId, fileInputStream);

            // Delete the file from S3 after successful processing
            s3Service.deleteFile(tenantId, s3Bucket, fileName);

        } catch (Exception e) {
            // Handle failure (e.g., send alert, log error)
            System.out.println("Error processing file: " + e.getMessage());
            // Optionally, publish failure alert to another Kafka topic or SNS
        }
    }
	
}
