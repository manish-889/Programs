package com.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column(name = "student_address")
	private String address;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String address) {
		super();
		this.addressId = addressId;
		this.address = address;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
