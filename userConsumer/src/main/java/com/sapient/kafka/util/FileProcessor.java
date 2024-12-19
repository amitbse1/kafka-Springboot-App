package com.sapient.kafka.util;

import java.io.InputStream;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public class FileProcessor {

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public void processFileWithRetry(String tenantId, InputStream fileInputStream) {
        try {
            // File processing logic
            System.out.println("Processing file for tenant: " + tenantId);
            // Add the actual file processing logic here

            // Simulating a failure for demonstration purposes
            if (Math.random() < 0.5) {
                throw new RuntimeException("File processing failed.");
            }

        } catch (Exception e) {
            System.out.println("Error processing file. Retrying...");
            throw e;  // Throwing the exception to trigger retry
        }
    }
}
