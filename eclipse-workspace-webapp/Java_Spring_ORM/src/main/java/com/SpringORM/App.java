package com.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.StudentDao;
import com.entities.Student;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringORM/OrmConfig.xml");
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean condition = true;
		while(condition) {
			System.out.println("1 for add new Student.");
			System.out.println("2 for display Students.");
			System.out.println("3 for show single Student Detail.");
			System.out.println("4 for Delete Student.");
			System.out.println("5 for Update details of Student.");
			System.out.println("6 for Exit the Application.");
			
			System.out.println("--> Enter your Choice :-");
			
			try {
				
				int choice = Integer.parseInt(br.readLine());
				
				switch(choice) {
					case 1:
						//for add new Student.
						
						//taking input from user
						System.out.println("Enter Student id :");
						int uId = Integer.parseInt(br.readLine());
						
						System.out.println("Enter Student name :");
						String uName = br.readLine();
						
						System.out.println("Enter Student name :");
						String uCity = br.readLine();
						
						//creating student object and setting value
						Student st = new Student(uId, uName, uCity);
						
						//saving student object to database by calling insert method of student dao
						int r = studentDao.insert(st);
						
						System.out.println(r +" Student added!!");
						System.out.println("*****************************");
						break;
					case 2:
						//for display student
						List<Student> list = studentDao.getAllStudents();
						System.out.println("***********************");
						for (Student student : list) {
							System.out.println("Student Id :"+student.getStudentId());
							System.out.println("Student Name :"+student.getStudentName());
							System.out.println("Student City :"+student.getStduentCity());
							System.out.println("___________________________________");
						}
						System.out.println("***********************");
						break;
					case 3:
						//for show single Student Detail.
						System.out.println("Enter Student name :");
						int uerId = Integer.parseInt(br.readLine());
						
						Student student  = studentDao.getStudent(uerId);
						
						System.out.println("Student Id :"+student.getStudentId());
						System.out.println("Student Name :"+student.getStudentName());
						System.out.println("Student City :"+student.getStduentCity());
						System.out.println("___________________________________");
						break;
					case 4:
						//for Delete Student.
						System.out.println("Enter Student name :");
						int uerId2 = Integer.parseInt(br.readLine());
						
						studentDao.deleteStudent(uerId2);
						System.out.println("Student deleted successfully!!");
						break;
					case 5:
						//for Update details of Student.
						System.out.println("___________________________________");
						System.out.println("Enter Student id :");
						int uId3 = Integer.parseInt(br.readLine());
						
						System.out.println("Enter Student name :");
						String uName2 = br.readLine();
						
						System.out.println("Enter Student name :");
						String uCity2 = br.readLine();
						
						Student st2 = new Student(uId3, uName2, uCity2);
						
						studentDao.updateStudent(st2);
						System.out.println("Student updated sucessfully....");
						System.out.println("___________________________________");
						break;
					case 6:
						//for Exit the Application.
						condition = false;
						break;
				}
				
			} catch (Exception e) {
				System.out.println("Enter valid choice!!!");
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Thank for using this Application!!!");
	}

}
