package com.sapient.kafka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tenant")
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "age")
	private String age;

	@Column(name = "uploaded_Files")
	private String uploadedFileLists;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUploadedFileLists() {
		return uploadedFileLists;
	}

	public void setUploadedFileLists(String uploadedFileLists) {
		this.uploadedFileLists = uploadedFileLists;
	}
	

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", age=" + age
				+ ", uploadedFileLists=" + uploadedFileLists + "]";
	}


	

}