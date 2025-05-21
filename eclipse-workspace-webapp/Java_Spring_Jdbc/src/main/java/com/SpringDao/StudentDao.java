package com.SpringDao;

import java.util.List;

import com.entity.Student;

public interface StudentDao {

	//for inserting data
	public int insert(Student student);
	
	//for update data
	public int update(Student student);
	
	//for getting single object
	public Student getStudent(int Id);
	
	//for getting all object
	public List<Student> getAllStudent();
}
