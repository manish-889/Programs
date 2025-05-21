package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public int createStudent(Student student) {
		return this.studentDao.savingStduent(student);
	}
	
}
