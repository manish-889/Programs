package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String studentName;
	private String subject;
	private String address;

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [ studentName=" + studentName + ", subject=" + subject + ", address=" + address
				+ "]";
	}
	
	
}
