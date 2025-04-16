package com.als.jdbc.reservation;

public class Reservation {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String Gender;
	private String Age;
	private String Email;
	private String Phone;
	@Override
	public String toString() {
		return "Reservation [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", Gender="
				+ Gender + ", Age=" + Age + ", Email=" + Email + ", Phone=" + Phone + "]";
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Reservation(int userNo, String userId, String userPwd, String userName, String gender, String age,
			String email, String phone) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		Gender = gender;
		Age = age;
		Email = email;
		Phone = phone;
	}
	public Reservation(String userId, String userPwd, String userName, String gender, String age, String email,
			String phone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		Gender = gender;
		Age = age;
		Email = email;
		Phone = phone;
	}
	public Reservation() {
		super();
	}
	

}
