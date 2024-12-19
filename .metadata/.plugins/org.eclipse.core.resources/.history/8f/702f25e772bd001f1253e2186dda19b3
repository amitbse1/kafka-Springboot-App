package com.sapient.kafka.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.kafka.dto.Tenant;


@Repository
public interface TenantRepository extends JpaRepository<Tenant, String> {
    Optional<Tenant> findById(String tenantId);
}