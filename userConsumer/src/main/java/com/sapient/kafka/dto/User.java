package com.sapient.kafka.dto;

import java.util.List;

public class User {
	
	private String userId;

	private String fName;

	private String lName;

	private String age;

	private List<String> uploadedFileLists;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<String> getUploadedFileLists() {
		return uploadedFileLists;
	}

	public void setUploadedFileLists(List<String> uploadedFileLists) {
		this.uploadedFileLists = uploadedFileLists;
	}

	}