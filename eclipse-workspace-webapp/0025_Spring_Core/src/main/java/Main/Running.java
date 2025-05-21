package Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Model.Question;
import Model.Student;

public class Running {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
//		Student st = (Student) context.getBean("std");
//		st.display();
		
		Question st = (Question) context.getBean("q");
		st.display();
		
	}
	
}
