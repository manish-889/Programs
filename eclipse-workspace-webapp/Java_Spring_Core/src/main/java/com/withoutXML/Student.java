package com.withoutXML;


public class Student {

	private Address address;
	

	public Student(Address address) {
		super();
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void study() {
		System.out.println("Student is study....");
		this.address.getAddress();
	}
}
