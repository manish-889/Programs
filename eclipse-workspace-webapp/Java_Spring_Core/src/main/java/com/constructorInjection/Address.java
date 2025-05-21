package com.constructorInjection;

public class Address {

	private String add;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String add) {
		super();
		this.add = add;
	}

	@Override
	public String toString() {
		return "Address [add=" + add + "]";
	}
	
	
}
