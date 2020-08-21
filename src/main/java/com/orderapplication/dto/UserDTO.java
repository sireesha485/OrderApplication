package com.orderapplication.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	
	@JsonProperty(value = "userId")
	private Long UserId;
	@JsonProperty(value = "userName")
	private String userName;
	@JsonProperty(value = "email")
	private String email;
	@JsonProperty(value = "phoneNo")
	private String phoneNo;
	@JsonProperty(value = "booking")
   
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
