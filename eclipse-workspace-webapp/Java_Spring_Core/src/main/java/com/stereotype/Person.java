package com.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {

	@Value("Manish")
	private String name;
	
	@Value("Bharuch")
	private String city;
	
	@Value("#{list}")
	private List<String> state;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	public List<String> getState() {
		return state;
	}

	public void setState(List<String> state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + "]";
	}
	
	
	
}
