package com.sapient.kafka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tenant")
public class TenantDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tenantId;
	
	@Column(name = "device_id")
	private String deviceId;

	@Column(name = "model")
	private String model;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "device_type")
	private String deviceType;

	@Column(name = "approval_date")
	private Date approvalDate;

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Override
	public String toString() {
		return "TenantDetail [tenantId=" + tenantId + ", deviceId=" + deviceId + ", model=" + model + ", manufacturer="
				+ manufacturer + ", deviceType=" + deviceType + "]";
	}
	

}