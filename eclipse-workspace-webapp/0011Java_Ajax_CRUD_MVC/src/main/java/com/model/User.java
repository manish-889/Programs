package com.model;

public class User {

	private int id;
	private String uname;
	private String email;
	private String phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String uname, String email, String phone) {
		super();
		this.uname = uname;
		this.email = email;
		this.phone = phone;
	}
	
	
}
