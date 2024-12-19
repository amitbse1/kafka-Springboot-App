package com.sapient.kafka.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;

    public S3Service() {
        this.amazonS3 = AmazonS3Client.builder()
                .withRegion(Regions.US_WEST_2)
                .build();
    }

    public InputStream downloadFile(String tenantId, String bucketName, String fileName) throws IOException {
        S3Object s3Object = amazonS3.getObject(new GetObjectRequest(bucketName, fileName));
        return s3Object.getObjectContent();
    }

    public void deleteFile(String tenantId, String bucketName, String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
    }
}
