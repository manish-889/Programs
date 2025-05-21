package com.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bike implements InitializingBean,DisposableBean{

	private String bikeName;

	public Bike(String bikeName) {
		super();
		this.bikeName = bikeName;
	}

	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBikeName() {
		return bikeName;
	}

	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	@Override
	public String toString() {
		return "Bike [bikeName=" + bikeName + "]";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bike Init() method call...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bike Destory method call...");
	}
	
	
	
}
