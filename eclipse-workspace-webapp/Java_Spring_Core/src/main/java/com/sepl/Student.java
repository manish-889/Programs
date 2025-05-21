package com.sepl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {


	@Value("#{11+22+33+44+55+66+77+88+99+00}")
	private int a;
	
	@Value("#{56-2}")
	private int b;
	
	//Doing Static method 
	@Value("#{ T(java.lang.Math).sqrt(25) }")
	private int c;
	
	//Doing Variable
	@Value("#{ T(java.lang.Math).PI }")
	private int d;
	
	//Doing Object
	@Value("#{ new String('Manish') }")
	private String e;
	
	//Doing for boolean
	@Value("#{ 8>3 }")
	private boolean f;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	@Override
	public String toString() {
		return "Student [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + "]";
	}
	
	
	
	
	
}
