package com.running;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringDao.StudentDao;
import com.entity.Student;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		StudentDao stDao =(StudentDao)  context.getBean("studentDao");
		
//		for inserting  data 
//		
//		Student st = new Student(233,"Hariom","Surat");
//		int result = stDao.insert(st);
		
		// for update data
//		Student st = new Student(22,"Manish","Ahemdabad");
//		int result = stDao.update(st);
		
		//for getting data
//		Student st = new Student();
//		Student st1 = stDao.getStudent(22);
		
		//for getting all data
		List<Student> list = stDao.getAllStudent();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
}
