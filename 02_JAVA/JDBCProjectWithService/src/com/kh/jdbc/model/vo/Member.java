package com.kh.jdbc.model.vo;

import java.sql.Date;

/*
 * VO(Value Object)
 * DB의 테이블정보를 Java에서 사용하기 위해 담아주는 객체
 * 한명의 회원(db테이블의 한 행의 데이터)에 대한 데이터를 기록할 수 있는 저장용 객체
 * 
 * */

public class Member {
	//필드는 기본적으로 db컬럼명과 유사하게 작업
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String Gender;
	private int Age;
	private String Email;
	private String Phone;
	private String Address;
	private String Hobby;
	private Date EnrollDate;
	public Member() {
		super();
	}
	public Member(int userNo, String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		Gender = gender;
		Age = age;
		Email = email;
		Phone = phone;
		Address = address;
		Hobby = hobby;
		EnrollDate = enrollDate;
	}
	public Member(String userId, String userPwd, String userName, String gender, int age, String email, String phone,
			String address, String hobby) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		Gender = gender;
		Age = age;
		Email = email;
		Phone = phone;
		Address = address;
		Hobby = hobby;
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
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getHobby() {
		return Hobby;
	}
	public void setHobby(String hobby) {
		Hobby = hobby;
	}
	public Date getEnrollDate() {
		return EnrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		EnrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return userNo + "," + userId + "," + userPwd + "," + userName
				+ "," + Gender + "," + Age + "," + Email + "," + Phone + ","
				+ Address + "," + Hobby + "," + EnrollDate;
	}
	
}