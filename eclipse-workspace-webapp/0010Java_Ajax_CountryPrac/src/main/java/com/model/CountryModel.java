package com.model;

public class CountryModel {
	private int id;
	private String name;
	
	public CountryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryModel(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
