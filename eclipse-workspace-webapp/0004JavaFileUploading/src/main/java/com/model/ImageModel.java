package com.model;

public class ImageModel {
	
	private int id;
	private String filename;
	private String name;
	
	
	public ImageModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ImageModel(String filename, String name) {
		super();
		this.filename = filename;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
