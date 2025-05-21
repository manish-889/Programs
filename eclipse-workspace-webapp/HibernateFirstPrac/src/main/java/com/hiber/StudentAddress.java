package com.hiber;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address")
public class StudentAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Address_ID")
	private int address_id;
	
	@Column(length = 50, name = "Street")
	private String street;
	
	@Column(length = 100, name = "City")
	private String city;
	
	@Column(name = "IsOpen")
	private boolean isOpen;
	
	@Transient
	private double X;
	
	@Column(name = "AddedDate")
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	public StudentAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public StudentAddress(int address_id, String street, String city, boolean isOpen, double x, Date addedDate) {
		super();
		this.address_id = address_id;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		X = x;
		this.addedDate = addedDate;
	}



	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}



	@Override
	public String toString() {
		return "StudentAddress [address_id=" + address_id + ", street=" + street + ", city=" + city + ", isOpen="
				+ isOpen + ", X=" + X + ", addedDate=" + addedDate + "]";
	}
	
	
	
	
}
