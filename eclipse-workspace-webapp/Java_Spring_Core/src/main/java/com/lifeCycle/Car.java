package com.lifeCycle;

public class Car {

	private String carName;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + "]";
	}
	
	public void init() {
		System.out.println("Car Inti method is called....");
	}
	
	public void destroy() {
		System.out.println("Car Destroy method is called....");
	}
}
