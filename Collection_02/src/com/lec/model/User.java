package com.lec.model;

public class User {

	String id;
	String pw;
	String address;
	String phone;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String pw, String address, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}


	//getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
