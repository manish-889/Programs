package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {

	@Id
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_city")
	private String stduentCity;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentName, String stduentCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.stduentCity = stduentCity;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStduentCity() {
		return stduentCity;
	}

	public void setStduentCity(String stduentCity) {
		this.stduentCity = stduentCity;
	}
	
	
}
