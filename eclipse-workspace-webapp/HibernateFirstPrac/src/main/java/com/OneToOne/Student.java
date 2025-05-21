package com.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@Column
	private String Student;
	
	@OneToOne
	private Address address;


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int studentId, String student, Address address) {
		super();
		this.studentId = studentId;
		Student = student;
		this.address = address;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudent() {
		return Student;
	}


	public void setStudent(String student) {
		Student = student;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	
}
