package com.Dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	// for inserting data
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);

		return i;
	}
    
	//for reading single data
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//for reading all data 
	public List<Student> getAllStudents(){
		List<Student> student = hibernateTemplate.loadAll(Student.class);
		return student;
	}
	
	//for updating data 
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}
	
	//for deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		hibernateTemplate.delete(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

}
