package com.sapient.kafka.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileProcessingService {

    @Autowired
    private TenantRepository tenantRepository; // Repositories can be tenant-specific

    public void processFile(String tenantId, InputStream fileInputStream) {
        // Parse the file content (example: CSV parsing)
        List<DeviceData> deviceDataList = parseFile(fileInputStream);

        // Persist data in tenant-specific database
        Tenant tenant = tenantRepository.findById(tenantId).orElseThrow(() -> new RuntimeException("Tenant not found"));
        for (DeviceData deviceData : deviceDataList) {
            tenant.getDeviceData().add(deviceData);
        }
        tenantRepository.save(tenant);
    }

    private List<DeviceData> parseFile(InputStream inputStream) {
        // Implement file parsing logic (e.g., CSV, JSON)
        return new ArrayList<>();
    }
}
