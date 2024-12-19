package com.sapient.kafka.dto;


public class Tenant {

	private Integer tenantId;

	private String deviceId;

	private String model;

	private String manufacturer;

	private String deviceType;
	
	private String approvalDate;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
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

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", deviceId=" + deviceId + ", model=" + model + ", manufacturer="
				+ manufacturer + ", deviceType=" + deviceType + ", approvalDate=" + approvalDate + "]";
	}
	
	

}
