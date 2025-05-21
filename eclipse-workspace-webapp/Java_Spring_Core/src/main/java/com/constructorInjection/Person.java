package com.constructorInjection;

public class Person {

	private int personId;
	private String personName;
	private Address add;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String personName, Address add) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.add = add;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAddress= " +add +"]";
	}
	
	
}
