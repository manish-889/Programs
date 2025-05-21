package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	private String email;
	private String passeord;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String passeord) {
		super();
		this.email = email;
		this.passeord = passeord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasseord() {
		return passeord;
	}

	public void setPasseord(String passeord) {
		this.passeord = passeord;
	}
	
}
