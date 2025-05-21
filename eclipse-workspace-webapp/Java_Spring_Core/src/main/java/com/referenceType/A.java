package com.referenceType;

public class A {

	private int num1;
	private B ob;
	
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public A(int num1, B ob) {
		super();
		this.num1 = num1;
		this.ob = ob;
	}
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public B getOb() {
		return ob;
	}
	public void setOb(B ob) {
		this.ob = ob;
	}
	
	@Override
	public String toString() {
		return "A [num1=" + num1 + ", ob=" + ob + "]";
	}
	
}
